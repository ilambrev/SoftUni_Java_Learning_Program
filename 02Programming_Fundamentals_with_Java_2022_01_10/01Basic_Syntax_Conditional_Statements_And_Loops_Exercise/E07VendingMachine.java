package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E07VendingMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double coinsSum = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                coinsSum += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            if (input.equals("Nuts")) {
                if (coinsSum >= 2.0) {
                    coinsSum -= 2.0;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Water")) {
                if (coinsSum >= 0.7) {
                    coinsSum -= 0.7;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Crisps")) {
                if (coinsSum >= 1.5) {
                    coinsSum -= 1.5;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Soda")) {
                if (coinsSum >= 0.8) {
                    coinsSum -= 0.8;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Coke")) {
                if (coinsSum >= 1.0) {
                    coinsSum -= 1.0;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", coinsSum);
    }
}