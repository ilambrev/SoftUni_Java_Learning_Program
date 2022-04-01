package whileLoop;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double balance = 0;

        while (!input.equals("NoMoreMoney")) {
            double currentAmount = Double.parseDouble(input);
            if (currentAmount < 0) {
                System.out.printf("Invalid operation!%n");
                break;
            } else {
                System.out.printf("Increase: %.2f%n", currentAmount);
                balance = balance + currentAmount;
                input = scanner.nextLine();
            }
        }
        System.out.printf("Total: %.2f", balance);
    }
}