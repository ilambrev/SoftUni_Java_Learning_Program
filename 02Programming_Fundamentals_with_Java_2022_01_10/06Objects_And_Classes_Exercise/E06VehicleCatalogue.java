package E06ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06VehicleCatalogue {

    static class Vehicle {
        String type;
        String model;
        String color;
        int power;

        Vehicle(String type, String model, String color, int power) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.power = power;
        }

        public String getType () {
            return this.type;
        }

        public String getModel() {
            return this.model;
        }

        public int getPower() {
            return this.power;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                    this.type.substring(0,1).toUpperCase() + this.type.substring(1).toLowerCase(), this.model, this.color, this.power);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();

        while (!inputString.equals("End")) {
            String[] input = inputString.split("\\s+");
            Vehicle vehicle = new Vehicle(input[0], input[1], input[2], Integer.parseInt(input[3]));
            vehicles.add(vehicle);
            inputString = scanner.nextLine();
        }

        inputString = scanner.nextLine();

        while (!inputString.equals("Close the Catalogue")) {
            for(Vehicle v : vehicles) {
                if (v.getModel().equals(inputString)) {
                    System.out.println(v);
                }
            }
            inputString = scanner.nextLine();
        }

        int sumOfCarsPower = 0;
        int carsCounter = 0;
        int sumOfTrucksPower = 0;
        int trucksCounter = 0;

        for (Vehicle v : vehicles) {
            if (v.getType().equals("car")) {
                sumOfCarsPower += v.getPower();
                carsCounter++;
            } else {
                sumOfTrucksPower += v.getPower();
                trucksCounter++;
            }
        }

        double carsAverageHP = 0.00;
        double trucksAverageHP = 0.00;

        if (carsCounter > 0) {
            carsAverageHP = sumOfCarsPower * 1.0 / carsCounter;
        }

        if (trucksCounter > 0) {
            trucksAverageHP = sumOfTrucksPower * 1.0 / trucksCounter;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverageHP);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksAverageHP);
    }
}