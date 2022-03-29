package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E04FishingBoat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermanNumber = Integer.parseInt(scanner.nextLine());

        double discount = 0;
        double totalPrice = 0;

        if (fishermanNumber <= 6) {
            discount = 0.10;
        } else if (fishermanNumber <= 11) {
            discount = 0.15;
        } else
            discount = 0.25;


        switch (season) {
            case "Spring":
                totalPrice = 3000 - 3000 * discount;
                break;
            case "Summer":
            case "Autumn":
                totalPrice = 4200 - 4200 * discount;
                break;
            case "Winter":
                totalPrice = 2600 - 2600 * discount;
                break;
        }
        if ((fishermanNumber % 2 == 0) && !season.equals("Autumn")) {
            totalPrice = totalPrice - totalPrice * 0.05;
        }
        if (budget >= totalPrice) {
            System.out.printf("Yes! You have %.2f leva left.", budget - totalPrice);
        } else
            System.out.printf("Not enough money! You need %.2f leva.", totalPrice - budget);
    }
}