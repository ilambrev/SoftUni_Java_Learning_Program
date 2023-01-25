package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentCreateDTO;
import softuni.exam.models.dto.ApartmentsDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.constants.FilePaths.APARTMENTS_XML_PATH;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return this.dataFromFile.read(APARTMENTS_XML_PATH);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<ApartmentCreateDTO>> violations;

        JAXBContext jaxbContext = JAXBContext.newInstance(ApartmentsDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readApartmentsFromFile());

        ApartmentsDTO apartmentsDTO = (ApartmentsDTO) unmarshaller.unmarshal(reader);

        for (ApartmentCreateDTO apartmentDTO : apartmentsDTO.getApartments()) {

            violations = this.validationUtil.violation(apartmentDTO);

            if (violations.isEmpty()) {

                Optional<Apartment> apartmentOptional = this.apartmentRepository
                        .findByTownNameAndArea(apartmentDTO.getTown(), apartmentDTO.getArea());

                Optional<Town> optionalTown = this.townRepository.findByTownName(apartmentDTO.getTown());

                if (apartmentOptional.isEmpty() && optionalTown.isPresent()) {

                    Town town = optionalTown.get();
                    Apartment apartment = this.modelMapper.map(apartmentDTO, Apartment.class);
                    apartment.setTown(town);

                    messages.append(String.format("Successfully imported apartment %s - %.2f",
                            apartment.getApartmentType(), apartment.getArea())).append(System.lineSeparator());

                    this.apartmentRepository.saveAndFlush(apartment);
                } else {
                    messages.append("Invalid apartment").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid apartment").append(System.lineSeparator());
            }

        }

        return messages.toString().trim();
    }

}