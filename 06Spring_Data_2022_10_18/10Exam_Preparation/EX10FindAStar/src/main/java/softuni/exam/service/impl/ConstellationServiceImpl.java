package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDTO;
import softuni.exam.models.entity.ConstellationEntity;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.models.enums.FilePathEnum.CONSTELLATIONS_JSON_PATH;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private final ConstellationRepository constellationRepository;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ValidationUtil validationUtil,
                                    Gson gson, ModelMapper modelMapper) {
        this.constellationRepository = constellationRepository;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_JSON_PATH));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder messages = new StringBuilder();

        ConstellationImportDTO[] constellationImportDTOs = this.gson.fromJson(readConstellationsFromFile(), ConstellationImportDTO[].class);

        for (ConstellationImportDTO constellationImportDTO : constellationImportDTOs) {

            if (this.validationUtil.isValid(constellationImportDTO)) {

                Optional<ConstellationEntity> optionalConstellation = this.constellationRepository.findByName(constellationImportDTO.getName());

                if (optionalConstellation.isEmpty()) {

                    ConstellationEntity constellation = this.modelMapper.map(constellationImportDTO, ConstellationEntity.class);

                    messages.append(String.format("Successfully imported constellation %s - %s",
                            constellation.getName(), constellation.getDescription())).append(System.lineSeparator());

                    this.constellationRepository.save(constellation);
                } else {
                    messages.append("Invalid constellation").append(System.lineSeparator());
                }

            } else {
                messages.append("Invalid constellation").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}