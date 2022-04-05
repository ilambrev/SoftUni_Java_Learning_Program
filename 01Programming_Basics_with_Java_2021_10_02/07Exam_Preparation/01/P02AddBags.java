package E2020_07_18And19;

import java.util.Scanner;

public class P02AddBags {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double luggagePriceOver20 = Double.parseDouble(scanner.nextLine());
        double luggageWeight = Double.parseDouble(scanner.nextLine());
        int daysToTrip = Integer.parseInt(scanner.nextLine());
        int luggageNumber = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;

        if (luggageWeight < 10) {
            totalPrice = luggagePriceOver20 * 0.20;
            if (daysToTrip < 7) {
                totalPrice = totalPrice + totalPrice * 0.40;
            } else if (daysToTrip <= 30) {
                totalPrice = totalPrice + totalPrice * 0.15;
            } else {
                totalPrice = totalPrice + totalPrice * 0.10;
            }
        } else if (luggageWeight <= 20) {
            totalPrice = luggagePriceOver20 * 0.50;
            if (daysToTrip < 7) {
                totalPrice = totalPrice + totalPrice * 0.40;
            } else if (daysToTrip <= 30) {
                totalPrice = totalPrice + totalPrice * 0.15;
            } else {
                totalPrice = totalPrice + totalPrice * 0.10;
            }
        } else {
            totalPrice = luggagePriceOver20;
            if (daysToTrip < 7) {
                totalPrice = totalPrice + totalPrice * 0.40;
            } else if (daysToTrip <= 30) {
                totalPrice = totalPrice + totalPrice * 0.15;
            } else {
                totalPrice = totalPrice + totalPrice * 0.10;
            }
        }
        System.out.printf("The total price of bags is: %.2f lv.", totalPrice * luggageNumber);
    }
}