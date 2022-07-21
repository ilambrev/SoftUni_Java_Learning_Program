package ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String driversName = scanner.nextLine();

        Car car = new Ferrari(driversName);

        System.out.println(car);

    }
}