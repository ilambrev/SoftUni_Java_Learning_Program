package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        Map<String, Engine> engines = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfEngines; i++) {
            String[] engineParameters = scanner.nextLine().split("\\s+");
            String model = engineParameters[0];
            int power = Integer.parseInt(engineParameters[1]);
            Engine engine;
            if (engineParameters.length == 2) {
                engine = new Engine(model, power);
            } else if (engineParameters.length == 3) {
                if (engineParameters[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(engineParameters[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = engineParameters[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else {
                int displacement = Integer.parseInt(engineParameters[2]);
                String efficiency = engineParameters[3];
                engine = new Engine(model, power, displacement, efficiency);
            }

            engines.put(model, engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCars; i++) {
            String[] carParameters = scanner.nextLine().split("\\s+");
            String model = carParameters[0];
            String engineModel = carParameters[1];
            Engine engine = engines.get(engineModel);
            Car car;
            if (carParameters.length == 2) {
                car = new Car(model, engine);
            } else if (carParameters.length == 3) {
                if (carParameters[2].matches("\\d+")) {
                    int weight = Integer.parseInt(carParameters[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = carParameters[2];
                    car = new Car(model, engine, color);
                }
            } else {
                int weight = Integer.parseInt(carParameters[2]);
                String color = carParameters[3];
                car = new Car(model, engine, weight, color);
            }

            cars.add(car);
        }

        cars.forEach(c -> System.out.println(c.toString()));

    }
}