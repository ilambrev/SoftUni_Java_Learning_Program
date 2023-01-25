package exam.service.impl;

import exam.model.dto.ShopCreateDTO;
import exam.model.dto.ShopsDTO;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
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

import static exam.constant.FilePaths.SHOPS_XML_PATH;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return this.dataFromFile.read(SHOPS_XML_PATH);
    }

    @Override
    public String importShops() throws JAXBException, IOException {

        StringBuilder messages = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(ShopsDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readShopsFileContent());

        ShopsDTO shopsDTO = (ShopsDTO) unmarshaller.unmarshal(reader);

        for (ShopCreateDTO shopDTO : shopsDTO.getShops()) {

            if (this.validationUtil.isValid(shopDTO)) {

                Optional<Shop> optionalShop = this.shopRepository.findByName(shopDTO.getName());

                Optional<Town> optionalTown = this.townRepository.findByName(shopDTO.getTown().getName());

                if (optionalShop.isEmpty() && optionalTown.isPresent()) {

                    Town town = optionalTown.get();
                    Shop shop = this.modelMapper.map(shopDTO, Shop.class);
                    shop.setTown(town);

                    messages.append(String.format("Successfully imported Shop %s - %.0f",
                            shop.getName(), shop.getIncome().doubleValue())).append(System.lineSeparator());

                    this.shopRepository.saveAndFlush(shop);
                } else {
                    messages.append("Invalid shop").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid shop").append(System.lineSeparator());
            }

        }

        return messages.toString().trim();
    }

}