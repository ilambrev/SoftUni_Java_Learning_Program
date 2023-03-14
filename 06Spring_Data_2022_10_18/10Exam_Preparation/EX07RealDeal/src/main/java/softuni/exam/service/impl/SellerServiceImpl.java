package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerCreateDTO;
import softuni.exam.models.dto.SellersDTO;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.SELLERS_XML_PATH;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, DataFromFile dataFromFile, ValidationUtil validationUtil,
                             XmlParser xmlParser, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return this.dataFromFile.read(SELLERS_XML_PATH);
    }

    @Override
    public String importSellers() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        SellersDTO sellerDTOs = this.xmlParser.parseXML(SellersDTO.class, readSellersFromFile());

        for (SellerCreateDTO sellerDTO : sellerDTOs.getSellers()) {

            if (this.validationUtil.isValid(sellerDTO)) {

                Optional<Seller> optionalSeller = this.sellerRepository.findByEmail(sellerDTO.getEmail());

                if (optionalSeller.isEmpty()) {

                    Seller seller = this.modelMapper.map(sellerDTO, Seller.class);
                    messages.append(String.format("Successfully import seller %s - %s",
                            seller.getLastName(), seller.getEmail())).append(System.lineSeparator());

                    this.sellerRepository.saveAndFlush(seller);

                } else {
                    messages.append("Invalid seller").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid seller").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}