package L02DataTypesAndVariables;

import java.util.Scanner;

public class L01ConvertMetersToKilometers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int distanceInMeters = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", distanceInMeters / 1000.0);
    }
}