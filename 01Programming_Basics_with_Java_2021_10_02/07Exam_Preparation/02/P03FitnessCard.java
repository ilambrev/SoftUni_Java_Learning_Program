package E2020_03_28And29;

import java.util.Scanner;

public class P03FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double initialAmount = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double cardPrice = 0;

        if (sex.equals("m")) {
            switch (sport) {
                case "Gym":
                    cardPrice = 42.00;
                    break;
                case "Boxing":
                    cardPrice = 41.00;
                    break;
                case "Yoga":
                    cardPrice = 45.00;
                    break;
                case "Zumba":
                    cardPrice = 34.00;
                    break;
                case "Dances":
                    cardPrice = 51.00;
                    break;
                case "Pilates":
                    cardPrice = 39.00;
                    break;
            }
        } else if (sex.equals("f")) {
            switch (sport) {
                case "Gym":
                    cardPrice = 35.00;
                    break;
                case "Boxing":
                    cardPrice = 37.00;
                    break;
                case "Yoga":
                    cardPrice = 42.00;
                    break;
                case "Zumba":
                    cardPrice = 31.00;
                    break;
                case "Dances":
                    cardPrice = 53.00;
                    break;
                case "Pilates":
                    cardPrice = 37.00;
                    break;
            }
        }
        if (age <= 19) {
            cardPrice = cardPrice - 0.20 * cardPrice;
        }
        if (initialAmount >= cardPrice) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", cardPrice - initialAmount);
        }
    }
}