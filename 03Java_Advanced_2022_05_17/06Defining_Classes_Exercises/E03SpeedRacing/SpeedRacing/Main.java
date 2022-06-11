package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int numberOfCarsToTrack = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCarsToTrack; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelConsumption = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelConsumption);
            cars.put(model, car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            String commandName = commandParts[0];
            String model = commandParts[1];
            int distance = Integer.parseInt(commandParts[2]);
            if (commandName.equals("Drive")) {
                if (!cars.get(model).drive(distance)) {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
            command = scanner.nextLine();
        }

        cars.values().forEach(car -> System.out.println(car.toString()));
    }
}