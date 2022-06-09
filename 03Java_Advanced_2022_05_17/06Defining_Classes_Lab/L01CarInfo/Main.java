package L06DefiningClasses.L01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCars; i++) {
            String[] carDetails = scanner.nextLine().split("\\s+");
            String brand = carDetails[0];
            String model = carDetails[1];
            int horsePower = Integer.parseInt(carDetails[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            System.out.println(car.carInfo());
        }

    }
}