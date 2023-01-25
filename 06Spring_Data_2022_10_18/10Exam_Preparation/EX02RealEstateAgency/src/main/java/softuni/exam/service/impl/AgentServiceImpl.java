package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentCreateDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.constants.FilePaths.AGENTS_JSON_PATH;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return this.dataFromFile.read(AGENTS_JSON_PATH);
    }

    @Override
    public String importAgents() throws IOException {

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<AgentCreateDTO>> violations;

        AgentCreateDTO[] agentDTOs = this.gson.fromJson(readAgentsFromFile(), AgentCreateDTO[].class);

        for (AgentCreateDTO agentDTO : agentDTOs) {
            violations = this.validationUtil.violation(agentDTO);

            if (violations.isEmpty()) {
                Optional<Town> townOptional = this.townRepository.findByTownName(agentDTO.getTown());
                Optional<Agent> agentOptionalByName = this.agentRepository.findByFirstName(agentDTO.getFirstName());
                Optional<Agent> agentOptionalByMail = this.agentRepository.findByEmail(agentDTO.getEmail());

                if (townOptional.isPresent() && agentOptionalByName.isEmpty() && agentOptionalByMail.isEmpty()) {
                    Agent agent = this.modelMapper.map(agentDTO, Agent.class);
                    agent.setTown(townOptional.get());

                    messages.append(String.format("Successfully imported agent - %s %s", agent.getFirstName(), agent.getLastName()))
                            .append(System.lineSeparator());

                    this.agentRepository.saveAndFlush(agent);
                } else {
                    messages.append("Invalid agent").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid agent").append(System.lineSeparator());
            }
        }


        return messages.toString().trim();
    }

}