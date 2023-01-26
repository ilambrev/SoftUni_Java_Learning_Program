package com.example.football.service.impl;

import com.example.football.models.dto.StatCreateDTO;
import com.example.football.models.dto.StatsDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.DataFromFile;
import com.example.football.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

import static com.example.football.constants.FilePaths.STATS_XML_PATH;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public StatServiceImpl(StatRepository statRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.statRepository = statRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return this.dataFromFile.read(STATS_XML_PATH);
    }

    @Override
    public String importStats() throws JAXBException, IOException {

        StringBuilder messages = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(StatsDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readStatsFileContent());

        StatsDTO statDTOs = (StatsDTO) unmarshaller.unmarshal(reader);

        for (StatCreateDTO statDTO : statDTOs.getStats()) {

            if (this.validationUtil.isValid(statDTO)) {

                Optional<Stat> statOptional = this.statRepository
                        .findByPassingAndShootingAndEndurance(statDTO.getPassing(), statDTO.getShooting(), statDTO.getEndurance());

                if (statOptional.isEmpty()) {

                    Stat stat = this.modelMapper.map(statDTO, Stat.class);

                    messages.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                            stat.getShooting(), stat.getPassing(), stat.getEndurance())).append(System.lineSeparator());

                    this.statRepository.saveAndFlush(stat);

                } else {
                    messages.append("Invalid Stat").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Stat").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}