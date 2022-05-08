package EX01MidExamRetake;

import java.util.Scanner;

public class EX01ComputerStore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalPriceWithoutTaxes = 0;

        while (!(input.equals("special") || input.equals("regular"))) {
            double currentPartPrice = Double.parseDouble(input);
            if (currentPartPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceWithoutTaxes += currentPartPrice;
            }

            input = scanner.nextLine();
        }
        double taxes = totalPriceWithoutTaxes * 0.20;
        double totalOrderPrice = totalPriceWithoutTaxes + taxes;

        if (input.equals("special")) {
            totalOrderPrice *= 0.90;
        }

        if (totalOrderPrice > 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalOrderPrice);
        } else {
            System.out.println("Invalid order!");
        }
    }
}