package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferCreateDTO;
import softuni.exam.models.dto.OffersDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.OFFERS_XML_PATH;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final ModelMapper offerModelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, CarRepository carRepository, SellerRepository sellerRepository,
                            DataFromFile dataFromFile, ValidationUtil validationUtil, XmlParser xmlParser,
                            @Qualifier("offerModelMapper") ModelMapper offerModelMapper) {
        this.offerRepository = offerRepository;
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.offerModelMapper = offerModelMapper;
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

        StringBuilder messages = new StringBuilder();

        OffersDTO offerDTOs = this.xmlParser.parseXML(OffersDTO.class, readOffersFileContent());

        for (OfferCreateDTO offerDTO : offerDTOs.getOffers()) {

            if (this.validationUtil.isValid(offerDTO)) {

                Optional<Offer> optionalOffer = this.offerRepository.
                        findByDescriptionAndAddedOn(offerDTO.getDescription(),
                                LocalDateTime.parse(offerDTO.getAddedOn(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                Optional<Car> optionalCar = this.carRepository.findById(offerDTO.getCar().getId());

                Optional<Seller> optionalSeller = this.sellerRepository.findById(offerDTO.getSeller().getId());

                if (optionalOffer.isEmpty() && optionalCar.isPresent() && optionalSeller.isPresent()) {

                    Car car = optionalCar.get();
                    Seller seller = optionalSeller.get();
                    Offer offer = this.offerModelMapper.map(offerDTO, Offer.class);
                    offer.setCar(car);
                    offer.setSeller(seller);
                    messages.append(String.format("Successfully import offer %s - %s",
                            offer.getAddedOn(),
                            offer.isHasGoldStatus())).append(System.lineSeparator());

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

}