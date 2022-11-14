package christmasRaces.core;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        if (driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format("Driver %s is already created.", driverName));
        }

        Driver driver = new DriverImpl(driverName);
        driverRepository.add(driver);

        return String.format("Driver %s is created.", driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;

        if ("Muscle".equals(type)) {
            car = new MuscleCar(model, horsePower);
        } else {
            car = new SportsCar(model, horsePower);
        }

        if (carRepository.getAll().stream().filter(c -> c.getModel()
                .equals(model) && c.getHorsePower() == horsePower)
                .findFirst().orElse(null) != null) {
            throw new IllegalArgumentException(String.format("Car %s is already created.", model));
        } else {
            carRepository.add(car);
        }

        return String.format("%s %s is created.", car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driver = driverRepository.getAll().stream().filter(d -> d.getName().equals(driverName)).findFirst().orElse(null);
        if (driver == null) {
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        }

        Car car = carRepository.getAll().stream().filter(c -> c.getModel().equals(carModel)).findFirst().orElse(null);
        if (car == null) {
            throw new IllegalArgumentException(String.format("Car %s could not be found.", carModel));
        }

        driver.addCar(car);

        return String.format("Driver %s received car %s.", driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = raceRepository.getAll().stream().filter(r -> r.getName().equals(raceName)).findFirst().orElse(null);
        if (race == null) {
            throw new IllegalArgumentException(String.format("Race %s could not be found.", raceName));
        }

        Driver driver = driverRepository.getAll().stream().filter(d -> d.getName().equals(driverName)).findFirst().orElse(null);
        if (driver == null) {
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        }

        race.addDriver(driver);

        return String.format("Driver %s added in %s race.", driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {

        Race race = raceRepository.getAll().stream().filter(r -> r.getName().equals(raceName)).findFirst().orElse(null);
        if (race == null) {
            throw new IllegalArgumentException(String.format("Race %s could not be found.", raceName));
        }

        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format("Race %s cannot start with less than 3 participants.", raceName));
        }

        Map<String, Double> driversInRace = new HashMap<>();

        for (Driver driver : race.getDrivers()) {
            Double points = driver.getCar().calculateRacePoints(race.getLaps());
            driversInRace.put(driver.getName(), points);
        }

        List<String> winners = driversInRace.entrySet().stream()
                .sorted((d1, d2) -> d2.getValue().compareTo(d1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        StringBuilder raceResult = new StringBuilder();
        raceResult.append(String.format("Driver %s wins %s race.", winners.get(0), raceName)).append(System.lineSeparator());
        raceResult.append(String.format("Driver %s is second in %s race.", winners.get(1), raceName)).append(System.lineSeparator());
        raceResult.append(String.format("Driver %s is third in %s race.", winners.get(2), raceName));

        return raceResult.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {

        Race race = raceRepository.getAll().stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
        if (race != null) {
            throw new IllegalArgumentException(String.format("Race %s is already created.", name));
        }

        race = new RaceImpl(name, laps);
        raceRepository.add(race);

        return String.format("Race %s is created.", name);
    }

}