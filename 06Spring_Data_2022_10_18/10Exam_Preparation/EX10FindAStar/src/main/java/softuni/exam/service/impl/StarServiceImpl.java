package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarExportDTO;
import softuni.exam.models.dto.StarImportDTO;
import softuni.exam.models.entity.ConstellationEntity;
import softuni.exam.models.entity.StarEntity;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.enums.FilePathEnum.STARS_JSON_PATH;

@Service
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository,
                           ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_JSON_PATH));
    }

    @Override
    public String importStars() throws IOException {

        StringBuilder messages = new StringBuilder();

        StarImportDTO[] starImportDTOs = this.gson.fromJson(readStarsFileContent(), StarImportDTO[].class);

        for (StarImportDTO starImportDTO : starImportDTOs) {

            if (this.validationUtil.isValid(starImportDTO)) {

                Optional<StarEntity> optionalStar = this.starRepository.findByName(starImportDTO.getName());
                Optional<ConstellationEntity> optionalConstellation = this.constellationRepository.findById(starImportDTO.getConstellation());

                if (optionalStar.isEmpty() && optionalConstellation.isPresent()) {

                    StarEntity star = this.modelMapper.map(starImportDTO, StarEntity.class);

                    star.setConstellation(optionalConstellation.get());

                    messages.append(String.format("Successfully imported star %s - %.2f light years",
                            star.getName(), star.getLightYears())).append(System.lineSeparator());

                    this.starRepository.save(star);
                } else {
                    messages.append("Invalid star").append(System.lineSeparator());
                }

            } else {
                messages.append("Invalid star").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String exportStars() {

        TypeMap<ConstellationEntity, StarExportDTO> propertyMapper = this.modelMapper.createTypeMap(ConstellationEntity.class, StarExportDTO.class);

        propertyMapper.addMapping(ConstellationEntity::getName, StarExportDTO::setConstellationName);

        StringBuilder starData = new StringBuilder();

        List<StarExportDTO> starExportDTOs = this.starRepository.findByLightYears()
                .stream().map(s -> this.modelMapper.map(s, StarExportDTO.class)).collect(Collectors.toList());

        starExportDTOs.forEach(s -> starData.append(s.toString()).append(System.lineSeparator()));

        return starData.toString().trim();
    }

}