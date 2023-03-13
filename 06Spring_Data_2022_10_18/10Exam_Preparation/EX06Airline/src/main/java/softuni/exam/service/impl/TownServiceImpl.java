package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownCreateDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.TOWNS_JSON_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil,
                           Gson gson, @Qualifier("modelMapper") ModelMapper modelMapper) {
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

        TownCreateDTO[] townDTOs = this.gson.fromJson(readTownsFileContent(), TownCreateDTO[].class);

        for (TownCreateDTO townDTO : townDTOs) {

            if (this.validationUtil.isValid(townDTO)) {

                Optional<Town> optionalTown = this.townRepository.findByName(townDTO.getName());

                if (optionalTown.isEmpty()) {

                    Town town = this.modelMapper.map(townDTO, Town.class);
                    messages.append(String.format("Successfully imported Town %s - %d",
                            town.getName(), town.getPopulation())).append(System.lineSeparator());

                    this.townRepository.saveAndFlush(town);

                } else {
                    messages.append("Invalid Town").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Town").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}