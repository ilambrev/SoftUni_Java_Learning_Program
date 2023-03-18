package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicCreateDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.service.MechanicService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.MECHANICS_JSON_PATH;

@Service
public class MechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public MechanicServiceImpl(MechanicRepository mechanicRepository, DataFromFile dataFromFile,
                               ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.mechanicRepository = mechanicRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.mechanicRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return this.dataFromFile.read(MECHANICS_JSON_PATH);
    }

    @Override
    public String importMechanics() throws IOException {

        StringBuilder messages = new StringBuilder();

        MechanicCreateDTO[] mechanicDTOs = this.gson.fromJson(readMechanicsFromFile(), MechanicCreateDTO[].class);

        for (MechanicCreateDTO mechanicDTO : mechanicDTOs) {

            if (this.validationUtil.isValid(mechanicDTO)) {

                Optional<Mechanic> optionalMechanicByFirstName = this.mechanicRepository.findByFirstName(mechanicDTO.getFirstName());
                Optional<Mechanic> optionalMechanicByEmail = this.mechanicRepository.findByEmail(mechanicDTO.getEmail());

                if (optionalMechanicByFirstName.isEmpty() && optionalMechanicByEmail.isEmpty()) {

                    Mechanic mechanic = this.modelMapper.map(mechanicDTO, Mechanic.class);
                    messages.append(String.format("Successfully imported mechanic %s %s",
                            mechanic.getFirstName(), mechanic.getLastName())).append(System.lineSeparator());

                    this.mechanicRepository.saveAndFlush(mechanic);

                } else {
                    messages.append("Invalid mechanic").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid mechanic").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}