package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCars; i++) {
            String[] carParameters = scanner.nextLine().split("\\s+");
            String carModel = carParameters[0];
            int engineSpeed = Integer.parseInt(carParameters[1]);
            int enginePower = Integer.parseInt(carParameters[2]);
            int cargoWeight = Integer.parseInt(carParameters[3]);
            String cargoType = carParameters[4];
            double tire1Pressure = Double.parseDouble(carParameters[5]);
            int tire1Age = Integer.parseInt(carParameters[6]);
            double tire2Pressure = Double.parseDouble(carParameters[7]);
            int tire2Age = Integer.parseInt(carParameters[8]);
            double tire3Pressure = Double.parseDouble(carParameters[9]);
            int tire3Age = Integer.parseInt(carParameters[10]);
            double tire4Pressure = Double.parseDouble(carParameters[11]);
            int tire4Age = Integer.parseInt(carParameters[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            Car car = new Car(carModel, engine, cargo);
            car.getTires()[0] = tire1;
            car.getTires()[1] = tire2;
            car.getTires()[2] = tire3;
            car.getTires()[3] = tire4;
            cars.add(car);

        }

        String searchedCargoType = scanner.nextLine();

        if (searchedCargoType.equals("fragile")) {
            System.out.println(cars.stream()
                    .filter(c -> c.getCargo().getType().equals("fragile") && c.pressureLimit(1))
                    .map(Car::toString)
                    .collect(Collectors.joining(System.lineSeparator())));
        } else {
            System.out.println(cars.stream()
                    .filter(c -> c.getCargo().getType().equals("flamable") && c.getEngine().getPower() > 250)
                    .map(Car::toString)
                    .collect(Collectors.joining(System.lineSeparator())));
        }

    }
}