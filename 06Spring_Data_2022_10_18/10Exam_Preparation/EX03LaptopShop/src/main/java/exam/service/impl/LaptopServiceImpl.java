package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopCreateDTO;
import exam.model.dto.LaptopExportDTO;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.DataFromFile;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static exam.constant.FilePaths.LAPTOPS_JSON_PATH;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return this.dataFromFile.read(LAPTOPS_JSON_PATH);
    }

    @Override
    public String importLaptops() throws IOException {

        StringBuilder messages = new StringBuilder();

        LaptopCreateDTO[] laptopDTOs = this.gson.fromJson(readLaptopsFileContent(), LaptopCreateDTO[].class);

        for (LaptopCreateDTO laptopDTO : laptopDTOs) {

            if (this.validationUtil.isValid(laptopDTO)) {

                Optional<Laptop> laptopOptional = this.laptopRepository.findByMacAddress(laptopDTO.getMacAddress());

                Optional<Shop> optionalShop = this.shopRepository.findByName(laptopDTO.getShop().getName());

                if (laptopOptional.isEmpty() && optionalShop.isPresent()) {

                    Shop shop = optionalShop.get();
                    Laptop laptop = this.modelMapper.map(laptopDTO, Laptop.class);
                    laptop.setShop(shop);

                    messages.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                    laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage()))
                            .append(System.lineSeparator());

                    this.laptopRepository.saveAndFlush(laptop);

                } else {
                    messages.append("Invalid Laptop").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Laptop").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String exportBestLaptops() {

        StringBuilder laptopsInfo = new StringBuilder();

        List<Laptop> laptops = this.laptopRepository.findAll();

        List<LaptopExportDTO> laptopDTOs = laptops.stream().map(l -> modelMapper.map(l, LaptopExportDTO.class)).toList();

        laptopDTOs.forEach(l -> laptopsInfo.append(l.toString()).append(System.lineSeparator()));

        return laptopsInfo.toString().trim();
    }

}