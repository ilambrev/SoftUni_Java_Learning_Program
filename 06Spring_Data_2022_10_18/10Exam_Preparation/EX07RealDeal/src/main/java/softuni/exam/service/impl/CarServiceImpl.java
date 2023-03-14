package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarCreateDTO;
import softuni.exam.models.dto.CarExportDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.CARS_JSON_PATH;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper carModelMapper;
    private final ModelMapper carExportModelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, DataFromFile dataFromFile, ValidationUtil validationUtil,
                          Gson gson, @Qualifier("carModelMapper") ModelMapper carModelMapper,
                          @Qualifier("carExportModelMapper") ModelMapper carExportModelMapper) {
        this.carRepository = carRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.carModelMapper = carModelMapper;
        this.carExportModelMapper = carExportModelMapper;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return this.dataFromFile.read(CARS_JSON_PATH);
    }

    @Override
    public String importCars() throws IOException {

        StringBuilder messages = new StringBuilder();

        CarCreateDTO[] carDTOs = this.gson.fromJson(readCarsFileContent(), CarCreateDTO[].class);

        for (CarCreateDTO carDTO : carDTOs) {

            if (this.validationUtil.isValid(carDTO)) {

                Optional<Car> optionalCar = this.carRepository
                        .findByMakeAndModelAndKilometers(carDTO.getMake(), carDTO.getModel(), carDTO.getKilometers());

                if (optionalCar.isEmpty()) {

                    Car car = this.carModelMapper.map(carDTO, Car.class);
                    messages.append(String.format("Successfully imported car - %s - %s",
                            car.getMake(), car.getModel())).append(System.lineSeparator());

                    this.carRepository.saveAndFlush(car);

                } else {
                    messages.append("Invalid car").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid car").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {

        StringBuilder carsDetails = new StringBuilder();

        List<CarExportDTO> carExportDTOs = this.carRepository.findByPictures()
                .stream().map(c -> this.carExportModelMapper.map(c, CarExportDTO.class)).toList();

        carExportDTOs.forEach(c -> carsDetails.append(c.toString()).append(System.lineSeparator()));

        return carsDetails.toString().trim();
    }

}