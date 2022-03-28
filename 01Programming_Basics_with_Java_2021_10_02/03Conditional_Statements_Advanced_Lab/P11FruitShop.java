package conditionalStatementsAdvanced;

import java.util.Scanner;

public class P11FruitShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double amount = Double.parseDouble(scanner.nextLine());

        double price = 0;
        boolean isValue = true;

        switch (dayOfWeek) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                if (fruit.equals("banana")) {
                    price = amount * 2.50;
                } else if (fruit.equals("apple")) {
                    price = amount * 1.20;
                } else if (fruit.equals("orange")) {
                    price = amount * 0.85;
                } else if (fruit.equals("grapefruit")) {
                    price = amount * 1.45;
                } else if (fruit.equals("kiwi")) {
                    price = amount * 2.70;
                } else if (fruit.equals("pineapple")) {
                    price = amount * 5.50;
                } else if (fruit.equals("grapes")) {
                    price = amount * 3.85;
                } else {
//                    System.out.println("error");
                    isValue = false;
                }
                break;
            case "Saturday":
            case "Sunday":
                if (fruit.equals("banana")) {
                    price = amount * 2.70;
                } else if (fruit.equals("apple")) {
                    price = amount * 1.25;
                } else if (fruit.equals("orange")) {
                    price = amount * 0.90;
                } else if (fruit.equals("grapefruit")) {
                    price = amount * 1.60;
                } else if (fruit.equals("kiwi")) {
                    price = amount * 3.00;
                } else if (fruit.equals("pineapple")) {
                    price = amount * 5.60;
                } else if (fruit.equals("grapes")) {
                    price = amount * 4.20;
                } else {
//                    System.out.println("error");
                    isValue = false;
                }
                break;
            default:
//                System.out.println("error");
                isValue = false;
                break;
        }
        if (isValue) {
            System.out.printf("%.2f", price);
        } else {
            System.out.println("error");
        }
    }
}