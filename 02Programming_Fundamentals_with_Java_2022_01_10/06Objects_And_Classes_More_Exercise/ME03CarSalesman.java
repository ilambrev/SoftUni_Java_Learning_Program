package ME06ObjectsAndClasses;

import java.util.Scanner;

public class ME03CarSalesman {

    static class Car {
        String model;
        Engine engine;
        String weight;
        String color;

        public Car(String model, Engine engine, String weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            String e = engine.toString();
            return String.format("%s:%n  %s%n  Weight: %s%n  Color: %s",
                    this.model, e, this.weight, this.color);
        }
    }

    static class Engine {
        String model;
        int power;
        String displacement;
        String efficiency;

        public Engine(String model, int power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public String getModel() {
            return this.model;
        }

        @Override
        public String toString() {
            return String.format("%s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s",
                    this.model, this.power, this.displacement, this.efficiency);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        Engine[] engines = new Engine[numberOfEngines];

        for (int i = 0; i < engines.length; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Engine engine;
            if (input.length == 2) {
                engine = new Engine(input[0], Integer.parseInt(input[1]), "n/a", "n/a");
            } else if (input.length == 3) {
                if (input[2].matches("[0-9]+")) {
                    engine = new Engine(input[0], Integer.parseInt(input[1]), input[2], "n/a");
                } else {
                    engine = new Engine(input[0], Integer.parseInt(input[1]), "n/a", input[2]);
                }
            } else {
                engine = new Engine(input[0], Integer.parseInt(input[1]), input[2], input[3]);
            }
            engines[i] = engine;
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Car[] cars = new Car[numberOfCars];

        for (int i = 0; i < cars.length; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car;
            Engine engine = engineModelCharacteristics(engines, input[1]);
            if (input.length == 2) {
                car = new Car(input[0], engine, "n/a", "n/a");
            } else if (input.length == 3) {
                if (input[2].matches("[0-9]+")) {
                    car = new Car(input[0], engine, input[2], "n/a");
                } else {
                    car = new Car(input[0], engine, "n/a", input[2]);
                }
            } else {
                car = new Car(input[0], engine, input[2], input[3]);
            }
            cars[i] = car;
        }

        for (Car c : cars) {
            System.out.println(c);
        }
    }

    private static Engine engineModelCharacteristics(Engine[] engines, String engine) {
        int index = 0;
        for (int i = 0; i < engines.length; i++) {
            if (engines[i].getModel().equals(engine)) {
                index = i;
                break;
            }
        }
        return engines[index];
    }

}