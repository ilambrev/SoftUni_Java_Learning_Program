package EX03FinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03NeedForSpeedIII {
    static class Car {
        String name;
        int mileage;
        int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMileage() {
            return this.mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return this.fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfCars; i++) {
            String[] carParams = scanner.nextLine().split("\\|");
            Car car = new Car(carParams[0], Integer.parseInt(carParams[1]), Integer.parseInt(carParams[2]));
            cars.put(carParams[0], car);
        }

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("Stop")) {
            String[] commandParams = inputCommand.split(" : ");
            String command = commandParams[0];
            switch (command) {
                case "Drive":
                    driveCar(cars, commandParams[1], Integer.parseInt(commandParams[2]), Integer.parseInt(commandParams[3]));
                    break;
                case "Refuel":
                    refuelCar(cars, commandParams[1], Integer.parseInt(commandParams[2]));
                    break;
                case "Revert":
                    revertMileage(cars, commandParams[1], Integer.parseInt(commandParams[2]));
                    break;
            }


            inputCommand = scanner.nextLine();
        }

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    entry.getKey(), entry.getValue().getMileage(), entry.getValue().getFuel());
        }

    }

    private static void driveCar(Map<String, Car> cars, String carName, int distance, int fuelNeeded) {
        if (cars.get(carName).getFuel() < fuelNeeded) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            int newMileage = cars.get(carName).getMileage() + distance;
            int newFuel = cars.get(carName).getFuel() - fuelNeeded;
            cars.get(carName).setMileage(newMileage);
            cars.get(carName).setFuel(newFuel);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuelNeeded);
            if (newMileage >= 100000) {
                cars.remove(carName);
                System.out.printf("Time to sell the %s!%n", carName);
            }
        }
    }

    private static void refuelCar(Map<String, Car> cars, String carName, int fuelToFill) {
        int oldFuel = cars.get(carName).getFuel();
        int refiledFuel = 0;
        if (oldFuel < 75) {
            if (75 - oldFuel < fuelToFill) {
                refiledFuel = 75 - oldFuel;
                cars.get(carName).setFuel(75);
            } else if (75 - oldFuel >= fuelToFill) {
                refiledFuel = fuelToFill;
                cars.get(carName).setFuel(oldFuel + fuelToFill);
            }
        }
        System.out.printf("%s refueled with %d liters%n", carName, refiledFuel);
    }

    private static void revertMileage(Map<String, Car> cars, String carName, int kilometersToRevert) {
        int oldMileage = cars.get(carName).getMileage();
        int newMileage = oldMileage - kilometersToRevert;
        if (newMileage < 10000) {
            newMileage = 10000;
        } else {
            System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometersToRevert);
        }
        cars.get(carName).setMileage(newMileage);
    }

}
