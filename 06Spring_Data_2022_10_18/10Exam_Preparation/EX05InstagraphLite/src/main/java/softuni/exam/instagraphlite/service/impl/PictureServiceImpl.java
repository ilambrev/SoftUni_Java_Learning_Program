package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureCreateDTO;
import softuni.exam.instagraphlite.models.dto.PictureExportDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.DataFromFile;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static softuni.exam.instagraphlite.constants.FilePaths.PICTURES_JSON_PATH;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, DataFromFile dataFromFile,
                              ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.dataFromFile.read(PICTURES_JSON_PATH);
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder messages = new StringBuilder();

        PictureCreateDTO[] pictureDTOs = this.gson.fromJson(readFromFileContent(), PictureCreateDTO[].class);

        for (PictureCreateDTO pictureDTO : pictureDTOs) {

            if (this.validationUtil.isValid(pictureDTO)) {

                Optional<Picture> pictureOptional = this.pictureRepository.findByPath(pictureDTO.getPath());

                if (pictureOptional.isEmpty()) {

                    Picture picture = this.modelMapper.map(pictureDTO, Picture.class);
                    messages.append(String.format("Successfully imported Picture, with size %.2f",
                            picture.getSize())).append(System.lineSeparator());

                    this.pictureRepository.saveAndFlush(picture);
                } else {
                    messages.append("Invalid Picture").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Picture").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String exportPictures() {

        StringBuilder picturesInfo = new StringBuilder();

        List<PictureExportDTO> pictureDTOs = this.pictureRepository.findBySize().stream()
                .map(p -> this.modelMapper.map(p, PictureExportDTO.class)).toList();

        pictureDTOs.forEach(p -> picturesInfo.append(p.toString()).append(System.lineSeparator()));

        return picturesInfo.toString().trim();
    }

}