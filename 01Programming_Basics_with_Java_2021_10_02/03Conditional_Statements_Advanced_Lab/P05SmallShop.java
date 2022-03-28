package conditionalStatementsAdvanced;

import java.util.Scanner;

public class P05SmallShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double amount = Double.parseDouble(scanner.nextLine());

        double price = 0;

        if (town.equals("Sofia")) {
            switch (product) {
                case "coffee":
                    price = amount * 0.50;
                    break;
                case "water":
                    price = amount * 0.80;
                    break;
                case "beer":
                    price = amount * 1.20;
                    break;
                case "sweets":
                    price = amount * 1.45;
                    break;
                case "peanuts":
                    price = amount * 1.60;
                    break;
            }
        }
        if (town.equals("Plovdiv")) {
            switch (product) {
                case "coffee":
                    price = amount * 0.40;
                    break;
                case "water":
                    price = amount * 0.70;
                    break;
                case "beer":
                    price = amount * 1.15;
                    break;
                case "sweets":
                    price = amount * 1.30;
                    break;
                case "peanuts":
                    price = amount * 1.50;
                    break;
            }
        }
        if (town.equals("Varna")) {
            switch (product) {
                case "coffee":
                    price = amount * 0.45;
                    break;
                case "water":
                    price = amount * 0.70;
                    break;
                case "beer":
                    price = amount * 1.10;
                    break;
                case "sweets":
                    price = amount * 1.35;
                    break;
                case "peanuts":
                    price = amount * 1.55;
                    break;
            }
        }

        System.out.println(price);
    }
}