package e02ConditionalStatements;

import java.util.Scanner;

public class E04ToyShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzleNumber = Integer.parseInt(scanner.nextLine());
        int dollNumber = Integer.parseInt(scanner.nextLine());
        int teddyNumber = Integer.parseInt(scanner.nextLine());
        int minionNumber = Integer.parseInt(scanner.nextLine());
        int truckNumber = Integer.parseInt(scanner.nextLine());

        int totalNumber = puzzleNumber + dollNumber + teddyNumber + minionNumber + truckNumber;
        double totalPrice = puzzleNumber * 2.60 + dollNumber * 3.00 + teddyNumber * 4.10 + minionNumber * 8.20 + truckNumber * 2.00;
        double profit = 0;

        if (totalNumber >= 50) {
            profit = totalPrice - totalPrice * 0.25 - (totalPrice - totalPrice * 0.25) * 0.1;
        } else {
            profit = totalPrice - totalPrice * 0.10;
        }
        if (profit >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", profit - tripPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice - profit);
        }

    }
}