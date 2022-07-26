package VehiclesExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();

        String[] carDetails = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carDetails[1]), Double.parseDouble(carDetails[2]), Integer.parseInt(carDetails[3]));
        vehicles.put(carDetails[0], car);

        String[] truckDetails = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckDetails[1]), Double.parseDouble(truckDetails[2]), Integer.parseInt(truckDetails[3]));
        vehicles.put(truckDetails[0], truck);

        String[] busDetails = scanner.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(busDetails[1]), Double.parseDouble(busDetails[2]), Integer.parseInt(busDetails[3]));
        vehicles.put(busDetails[0], bus);

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
                case "DriveEmpty":
                    Bus currentBus = (Bus) vehicle;
                    System.out.println(currentBus.driveEmpty(Double.parseDouble(tokens[2])));
                    break;
            }

        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}