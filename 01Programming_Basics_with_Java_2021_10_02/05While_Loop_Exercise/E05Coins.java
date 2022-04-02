package e05WhileLoop;

import java.util.Scanner;

public class E05Coins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());

        double changeInCoins = change * 100;
        double coins = 0;

        while (changeInCoins > 0) {
            if (changeInCoins >= 200) {
                coins = coins + Math.floor(changeInCoins / 200);
                changeInCoins = changeInCoins % 200;
            } else if (changeInCoins >= 100) {
                coins = coins + Math.floor(changeInCoins / 100);
                changeInCoins = changeInCoins % 100;
            } else if (changeInCoins >= 50) {
                coins = coins + Math.floor(changeInCoins / 50);
                changeInCoins = changeInCoins % 50;
            }  else if (changeInCoins >= 20) {
                coins = coins + Math.floor(changeInCoins / 20);
                changeInCoins = changeInCoins % 20;
            } else if (changeInCoins >= 10) {
                coins = coins + Math.floor(changeInCoins / 10);
                changeInCoins = changeInCoins % 10;
            } else if (changeInCoins >= 5) {
                coins = coins + Math.floor(changeInCoins / 5);
                changeInCoins = changeInCoins % 5;
            } else if (changeInCoins >= 2) {
                coins = coins + Math.floor(changeInCoins / 2);
                changeInCoins = changeInCoins % 2;
            }  else if (changeInCoins >= 1) {
                coins = coins + Math.floor(changeInCoins / 1);
                changeInCoins = changeInCoins % 1;
            } else {
                break;
            }
        }
        System.out.printf("%.0f", coins);
    }
}