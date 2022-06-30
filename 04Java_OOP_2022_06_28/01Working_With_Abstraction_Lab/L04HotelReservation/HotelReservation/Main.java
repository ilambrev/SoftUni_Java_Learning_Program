package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(inputData[0]);
        int numberOfDays = Integer.parseInt(inputData[1]);
        Season season = Season.parse(inputData[2].toUpperCase().toUpperCase());
        DiscountType discountType = DiscountType.parse(inputData[3].toUpperCase().toUpperCase());

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f", calculator.calculateTotalPrice());

    }
}