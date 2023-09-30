package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDTO;
import softuni.exam.models.dto.AstronomersDTO;
import softuni.exam.models.entity.AstronomerEntity;
import softuni.exam.models.entity.StarEntity;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.models.enums.FilePathEnum.ASTRONOMERS_XML_PATH;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_XML_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<AstronomerImportDTO>> violations;

        JAXBContext jaxbContext = JAXBContext.newInstance(AstronomersDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readAstronomersFromFile());

        AstronomersDTO astronomersDTO = (AstronomersDTO) unmarshaller.unmarshal(reader);

        for (AstronomerImportDTO astronomerImportDTO : astronomersDTO.getAstronomers()) {

            violations = this.validationUtil.violation(astronomerImportDTO);

            if (violations.isEmpty()) {

                Optional<AstronomerEntity> optionalAstronomer = this.astronomerRepository.findByFirstNameAndLastName(astronomerImportDTO.getFirstName(), astronomerImportDTO.getLastName());
                Optional<StarEntity> optionalStar = this.starRepository.findById(astronomerImportDTO.getObservingStar());

                if (optionalAstronomer.isEmpty() && optionalStar.isPresent()) {

                    AstronomerEntity astronomer = this.modelMapper.map(astronomerImportDTO, AstronomerEntity.class);

                    astronomer.setObservingStar(optionalStar.get());

                    messages.append(String.format("Successfully imported astronomer %s %s - %.2f",
                            astronomer.getFirstName(), astronomer.getLastName(), astronomer.getAverageObservationHours())).append(System.lineSeparator());

                    this.astronomerRepository.save(astronomer);

                } else {
                    messages.append("Invalid astronomer").append(System.lineSeparator());
                }

            } else {
                messages.append("Invalid astronomer").append(System.lineSeparator());
            }

        }

        return messages.toString().trim();
    }

}