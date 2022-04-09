package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E09Orders {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ordersAmount = Integer.parseInt(scanner.nextLine());

        double totalOrdersSum = 0;

        for (int i = 1; i <= ordersAmount; i++) {
            double capsulePrice = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double totalOrderPrice = ((days * capsulesCount) * capsulePrice);
            System.out.printf("The price for the coffee is: $%.2f%n", totalOrderPrice);
            totalOrdersSum += totalOrderPrice;
        }
        System.out.printf("Total: $%.2f", totalOrdersSum);
    }
}