package L06DefiningClasses.L02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= numberOfCars; i++) {
            String[] carDetails = scanner.nextLine().split("\\s+");
            String brand = carDetails[0];
            Car car;

            if (carDetails.length == 1) {
                car = new Car(brand);
            } else {
                String model = carDetails[1];
                int horsePower = Integer.parseInt(carDetails[2]);
                car = new Car(brand, model, horsePower);
            }

            cars.add(car);

        }

        cars.forEach(car -> System.out.println(car.carInfo()));

    }
}