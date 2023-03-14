package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PictureCreateDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.PICTURES_JSON_PATH;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final CarRepository carRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper pictureModelMapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, CarRepository carRepository, DataFromFile dataFromFile,
                              ValidationUtil validationUtil, Gson gson,
                              @Qualifier("pictureModelMapper") ModelMapper pictureModelMapper) {
        this.pictureRepository = pictureRepository;
        this.carRepository = carRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.pictureModelMapper = pictureModelMapper;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return this.dataFromFile.read(PICTURES_JSON_PATH);
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder messages = new StringBuilder();

        PictureCreateDTO[] pictureDTOs = this.gson.fromJson(readPicturesFromFile(), PictureCreateDTO[].class);

        for (PictureCreateDTO pictureDTO : pictureDTOs) {

            if (this.validationUtil.isValid(pictureDTO)) {

                Optional<Picture> optionalPicture = this.pictureRepository.findByName(pictureDTO.getName());
                Optional<Car> optionalCar = this.carRepository.findById(pictureDTO.getCar());

                if (optionalPicture.isEmpty() && optionalCar.isPresent()) {

                    Car car = optionalCar.get();
                    Picture picture = this.pictureModelMapper.map(pictureDTO, Picture.class);
                    picture.setCar(car);
                    messages.append(String.format("Successfully import picture - %s",
                            picture.getName())).append(System.lineSeparator());

                    this.pictureRepository.saveAndFlush(picture);

                } else {
                    messages.append("Invalid picture").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid picture").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}