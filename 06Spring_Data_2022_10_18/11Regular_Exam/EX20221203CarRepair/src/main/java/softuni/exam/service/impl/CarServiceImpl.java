package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarCreateDTO;
import softuni.exam.models.dto.CarsDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.CARS_XML_PATH;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, XmlParser xmlParser, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return this.dataFromFile.read(CARS_XML_PATH);
    }

    @Override
    public String importCars() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        CarsDTO carDTOs = this.xmlParser.parseXML(CarsDTO.class, readCarsFromFile());

        for (CarCreateDTO carDTO : carDTOs.getCars()) {

            if (this.validationUtil.isValid(carDTO)) {

                Optional<Car> optionalCar = this.carRepository.findByPlateNumber(carDTO.getPlateNumber());

                if (optionalCar.isEmpty()) {

                    Car car = this.modelMapper.map(carDTO, Car.class);
                    messages.append(String.format("Successfully imported car %s - %s",
                            car.getCarMake(), car.getCarModel())).append(System.lineSeparator());

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

}