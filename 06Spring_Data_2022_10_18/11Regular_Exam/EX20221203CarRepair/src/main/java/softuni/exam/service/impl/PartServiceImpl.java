package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartCreateDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartRepository;
import softuni.exam.service.PartService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.PARTS_JSON_PATH;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.partRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return this.dataFromFile.read(PARTS_JSON_PATH);
    }

    @Override
    public String importParts() throws IOException {

        StringBuilder messages = new StringBuilder();

        PartCreateDTO[] partDTOs = this.gson.fromJson(readPartsFileContent(), PartCreateDTO[].class);

        for (PartCreateDTO partDTO : partDTOs) {

            if (this.validationUtil.isValid(partDTO)) {

                Optional<Part> optionalPart = this.partRepository.findByPartName(partDTO.getPartName());

                if (optionalPart.isEmpty()) {

                    Part part = this.modelMapper.map(partDTO, Part.class);
                    messages.append(String.format("Successfully imported part %s - %.2f",
                            part.getPartName(), part.getPrice())).append(System.lineSeparator());

                    this.partRepository.saveAndFlush(part);

                } else {
                    messages.append("Invalid part").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid part").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}