package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownCreateDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.constants.FilePaths.TOWNS_JSON_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;


    @Autowired
    public TownServiceImpl(TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return this.dataFromFile.read(TOWNS_JSON_PATH);
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<TownCreateDTO>> violations;

        TownCreateDTO[] townDTOs = this.gson.fromJson(readTownsFileContent(), TownCreateDTO[].class);

        for (TownCreateDTO townDTO : townDTOs) {

            violations = this.validationUtil.violation(townDTO);

            if (violations.isEmpty()) {
                Optional<Town> townOptional = this.townRepository.findByTownName(townDTO.getTownName());

                if (townOptional.isPresent()) {
                    messages.append("Invalid town").append(System.lineSeparator());
                } else {
                    Town town = this.modelMapper.map(townDTO, Town.class);
                    messages.append(String.format("Successfully imported town %s - %d", town.getTownName(), town.getPopulation()))
                            .append(System.lineSeparator());
                    this.townRepository.saveAndFlush(town);
                }
            } else {
                messages.append("Invalid town").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}