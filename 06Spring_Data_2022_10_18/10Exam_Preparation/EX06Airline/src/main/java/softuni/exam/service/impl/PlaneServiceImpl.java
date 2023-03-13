package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneCreateDTO;
import softuni.exam.models.dto.PlanesDTO;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.PLANES_XML_PATH;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, DataFromFile dataFromFile, ValidationUtil validationUtil,
                            XmlParser xmlParser, @Qualifier("modelMapper") ModelMapper modelMapper) {
        this.planeRepository = planeRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return this.dataFromFile.read(PLANES_XML_PATH);
    }

    @Override
    public String importPlanes() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        PlanesDTO planeDTOs = this.xmlParser.parseXML(PlanesDTO.class, readPlanesFileContent());

        for (PlaneCreateDTO planeDTO : planeDTOs.getPlanes()) {

            if (this.validationUtil.isValid(planeDTO)) {

                Optional<Plane> optionalPlane = this.planeRepository.findByRegisterNumber(planeDTO.getRegisterNumber());

                if (optionalPlane.isEmpty()) {

                    Plane plane = this.modelMapper.map(planeDTO, Plane.class);
                    messages.append(String.format("Successfully imported Plane %s",
                            plane.getRegisterNumber())).append(System.lineSeparator());

                    this.planeRepository.saveAndFlush(plane);

                } else {
                    messages.append("Invalid Plane").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Plane").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}