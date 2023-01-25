package softuni.exam.service.impl;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferCreateDTO;
import softuni.exam.models.dto.OfferExportDTO;
import softuni.exam.models.dto.OffersDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.constants.FilePaths.OFFERS_XML_PATH;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, DataFromFile dataFromFile, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return this.dataFromFile.read(OFFERS_XML_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> stringToDate = new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        };

        PropertyMap<OfferCreateDTO, Offer> offerMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(stringToDate).map(source.getPublishedOn(), destination.getPublishedOn());
            }
        };

        modelMapper.addMappings(offerMap);

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<OfferCreateDTO>> violations;

        JAXBContext jaxbContext = JAXBContext.newInstance(OffersDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readOffersFileContent());

        OffersDTO offersDTO = (OffersDTO) unmarshaller.unmarshal(reader);

        for (OfferCreateDTO offerDTO : offersDTO.getOffers()) {

            violations = this.validationUtil.violation(offerDTO);

            if (violations.isEmpty()) {

                Optional<Agent> agentOptional = this.agentRepository.findByFirstName(offerDTO.getAgent().getName());

                Optional<Apartment> apartmentOptional = this.apartmentRepository.findById(offerDTO.getApartment().getId());

                if (agentOptional.isPresent() && apartmentOptional.isPresent()) {

                    Agent agent = agentOptional.get();
                    Apartment apartment = apartmentOptional.get();
                    Offer offer = modelMapper.map(offerDTO, Offer.class);
                    offer.setAgent(agent);
                    offer.setApartment(apartment);

                    messages.append(String.format("Successfully imported offer %.2f",
                            offer.getPrice().doubleValue())).append(System.lineSeparator());

                    this.offerRepository.saveAndFlush(offer);
                } else {
                    messages.append("Invalid offer").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid offer").append(System.lineSeparator());
            }

        }

        return messages.toString().trim();
    }

    @Override
    public String exportOffers() {

        ModelMapper modelMapper = new ModelMapper();

        StringBuilder offersData = new StringBuilder();

        List<Offer> offers = this.offerRepository.findByApartmentType();

        List<OfferExportDTO> forecastDTOs = offers.stream().map(o -> modelMapper.map(o, OfferExportDTO.class)).toList();

        forecastDTOs.forEach(o -> offersData.append(o.toString()).append(System.lineSeparator()));

        return offersData.toString().trim();
    }

}