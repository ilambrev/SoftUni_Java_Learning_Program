package exam.service.impl;

import exam.model.dto.TownCreateDTO;
import exam.model.dto.TownsDTO;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.DataFromFile;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

import static exam.constant.FilePaths.TOWNS_XML_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return this.dataFromFile.read(TOWNS_XML_PATH);
    }

    @Override
    public String importTowns() throws JAXBException, IOException {

        StringBuilder messages = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(TownsDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readTownsFileContent());

        TownsDTO townsDTO = (TownsDTO) unmarshaller.unmarshal(reader);

        for (TownCreateDTO townDTO: townsDTO.getTowns()) {

            if (this.validationUtil.isValid(townDTO)) {

                Optional<Town> optionalTown = this.townRepository.findByName(townDTO.getName());

                if (optionalTown.isEmpty()) {

                    Town town = this.modelMapper.map(townDTO, Town.class);

                    messages.append(String.format("Successfully imported Town %s", town.getName())).append(System.lineSeparator());

                    this.townRepository.saveAndFlush(town);

                } else {
                    messages.append("Invalid town").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid town").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}