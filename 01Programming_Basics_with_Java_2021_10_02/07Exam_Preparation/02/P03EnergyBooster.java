package E2020_03_28And29;

import java.util.Scanner;

public class P03EnergyBooster {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int setsNumber = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;

        switch (fruit) {
            case "Watermelon":
                if (size.equals("small")) {
                    totalPrice = 56.00 * setsNumber * 2;
                } else if (size.equals("big")) {
                    totalPrice = 28.70 * setsNumber * 5;
                }
                break;
            case "Mango":
                if (size.equals("small")) {
                    totalPrice = 36.66 * setsNumber * 2;
                } else if (size.equals("big")) {
                    totalPrice = 19.60 * setsNumber * 5;
                }
                break;
            case "Pineapple":
                if (size.equals("small")) {
                    totalPrice = 42.10 * setsNumber * 2;
                } else if (size.equals("big")) {
                    totalPrice = 24.80 * setsNumber * 5;
                }
                break;
            case "Raspberry":
                if (size.equals("small")) {
                    totalPrice = 20.00 * setsNumber * 2;
                } else if (size.equals("big")) {
                    totalPrice = 15.20 * setsNumber * 5;
                }
                break;
        }
        if (totalPrice >= 400 && totalPrice <= 1000) {
            totalPrice = totalPrice - 0.15 * totalPrice;
        } else if (totalPrice > 1000) {
            totalPrice = totalPrice - 0.50 * totalPrice;
        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}