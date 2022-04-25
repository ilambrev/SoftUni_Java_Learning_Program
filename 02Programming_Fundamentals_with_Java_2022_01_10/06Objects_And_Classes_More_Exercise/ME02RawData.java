package ME06ObjectsAndClasses;

import java.util.Scanner;

public class ME02RawData {

    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tyre[] tyres;

        public Car(String model, Engine engine, Cargo cargo, Tyre[] tyres) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tyres = tyres;
        }

        public Engine getEngine() {
            return this.engine;
        }

        public Cargo getCargo() {
            return this.cargo;
        }

        public Tyre[] getTyres() {
            return tyres;
        }

        public boolean powerOver250HP(Engine engine) {
            return engine.getPower() > 250;
        }

        public boolean criticalPressure(Tyre[] tyres) {
            for (Tyre t : tyres) {
                if (t.getPressure() < 1) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return String.format("%s", this.model);
        }

    }

    static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return this.power;
        }

    }

    static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

    }

    static class Tyre {
        double pressure;
        int age;

        public Tyre(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return this.pressure;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Car[] cars = new Car[numberOfCars];
        Tyre[] currentTyres = new Tyre[4];

        for (int i = 0; i < cars.length; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            for (int j = 0; j < currentTyres.length; j++) {
                Tyre tyre = new Tyre(Double.parseDouble(input[5 + (2 * j)]), Integer.parseInt(input[6 + (2 * j)]));
                currentTyres[j] = tyre;
            }
            Tyre[] tyres = currentTyres.clone();
            Car car = new Car(input[0], engine, cargo, tyres);
            cars[i] = car;
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car c : cars) {
                if (c.getCargo().getType().equals("fragile") && c.criticalPressure(c.getTyres())){
                    System.out.println(c.model);
                }
            }
        } else if (command.equals("flamable")) {
            for (Car c : cars) {
                if (c.getCargo().getType().equals("flamable") && c.powerOver250HP(c.getEngine())) {
                    System.out.println(c.model);
                }
            }
        }
    }
}