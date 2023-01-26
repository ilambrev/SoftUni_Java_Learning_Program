package com.example.football.service.impl;

import com.example.football.models.dto.PlayerCreateDTO;
import com.example.football.models.dto.PlayerExportDTO;
import com.example.football.models.dto.PlayersDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.DataFromFile;
import com.example.football.util.ValidationUtil;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.example.football.constants.FilePaths.PLAYERS_XML_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, TeamRepository teamRepository,
                             StatRepository statRepository, DataFromFile dataFromFile, ValidationUtil validationUtil) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return this.dataFromFile.read(PLAYERS_XML_PATH);
    }

    @Override
    public String importPlayers() throws JAXBException, IOException {

        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> stringToDate = new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        };

        PropertyMap<PlayerCreateDTO, Player> customerMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(stringToDate).map(source.getBirthDate(), destination.getBirthDate());
            }
        };

        modelMapper.addMappings(customerMap);

        StringBuilder messages = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(PlayersDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readPlayersFileContent());

        PlayersDTO playerDTOs = (PlayersDTO) unmarshaller.unmarshal(reader);

        for (PlayerCreateDTO playerDTO : playerDTOs.getPlayers()) {

            if (this.validationUtil.isValid(playerDTO)) {

                Optional<Player> optionalPlayer = this.playerRepository.findByEmail(playerDTO.getEmail());

                Optional<Town> optionalTown = this.townRepository.findByName(playerDTO.getTown().getName());

                Optional<Team> optionalTeam = this.teamRepository.findByName(playerDTO.getTeam().getName());

                Optional<Stat> optionalStat = this.statRepository.findStatById(playerDTO.getStat().getId());

                if (optionalPlayer.isEmpty() && optionalTown.isPresent() &&
                        optionalTeam.isPresent() && optionalStat.isPresent()) {

                    Town town = optionalTown.get();
                    Team team = optionalTeam.get();
                    Stat stat = optionalStat.get();
                    Player player = modelMapper.map(playerDTO, Player.class);
                    player.setTown(town);
                    player.setTeam(team);
                    player.setStat(stat);

                    messages.append(String.format("Successfully imported Player %s %s - %s",
                            player.getFirstName(), player.getLastName(), player.getPosition())).append(System.lineSeparator());

                    this.playerRepository.saveAndFlush(player);

                } else {
                    messages.append("Invalid Player").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Player").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String exportBestPlayers() {

        ModelMapper modelMapper = new ModelMapper();

        StringBuilder playersInfo = new StringBuilder();

        LocalDate afterDate = LocalDate.parse("02-01-1995",DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate beforeDate = LocalDate.parse("31-12-2002",DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        List<PlayerExportDTO> playerDTOs = this.playerRepository.findByBirthDate(afterDate, beforeDate)
                .stream().map(p -> modelMapper.map(p, PlayerExportDTO.class)).toList();

        playerDTOs.forEach(p -> playersInfo.append(p.toString()).append(System.lineSeparator()));

        return playersInfo.toString().trim();
    }

}