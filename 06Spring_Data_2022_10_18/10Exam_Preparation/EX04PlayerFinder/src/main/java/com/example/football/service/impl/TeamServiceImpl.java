package com.example.football.service.impl;

import com.example.football.models.dto.TeamCreateDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.DataFromFile;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

import static com.example.football.constants.FilePaths.TEAMS_JSON_PATH;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return this.dataFromFile.read(TEAMS_JSON_PATH);
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder messages = new StringBuilder();

        TeamCreateDTO[] teamDTOs = this.gson.fromJson(readTeamsFileContent(), TeamCreateDTO[].class);

        for (TeamCreateDTO teamDTO : teamDTOs) {

            if (this.validationUtil.isValid(teamDTO)) {

                Optional<Team> teamOptional = this.teamRepository.findByName(teamDTO.getName());

                Optional<Town> townOptional = this.townRepository.findByName(teamDTO.getTownName());

                if (teamOptional.isEmpty() && townOptional.isPresent()) {

                    Town town = townOptional.get();
                    Team team = this.modelMapper.map(teamDTO, Team.class);
                    team.setTown(town);

                    messages.append(String.format("Successfully imported Team %s - %s",
                            team.getName(), team.getFanBase())).append(System.lineSeparator());

                    this.teamRepository.saveAndFlush(team);

                } else {
                    messages.append("Invalid Team").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Team").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}