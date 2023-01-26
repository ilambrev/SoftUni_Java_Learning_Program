package com.example.football.service.impl;

import com.example.football.models.dto.TownCreateDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.DataFromFile;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

import static com.example.football.constants.FilePaths.TOWNS_JSON_PATH;

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

        TownCreateDTO[] townDTOs = this.gson.fromJson(readTownsFileContent(), TownCreateDTO[].class);

        for (TownCreateDTO townDTO : townDTOs) {

            if (this.validationUtil.isValid(townDTO)) {

                Optional<Town> townOptional = this.townRepository.findByName(townDTO.getName());

                if (townOptional.isEmpty()) {

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