package Vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();

        String[] carDetails = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carDetails[1]), Double.parseDouble(carDetails[2]));
        vehicles.put(carDetails[0], car);

        String[] truckDetails = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckDetails[1]), Double.parseDouble(truckDetails[2]));
        vehicles.put(truckDetails[0], truck);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];

            Vehicle vehicle = vehicles.get(vehicleType);

            switch (command) {
                case "Drive":
                    System.out.println(vehicle.drive(Double.parseDouble(tokens[2])));
                    break;
                case "Refuel":
                    vehicle.refuel(Double.parseDouble(tokens[2]));
                    break;
            }

        }

        System.out.println(car);
        System.out.println(truck);

    }
}