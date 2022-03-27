package e02ConditionalStatements;

import java.util.Scanner;

public class E05GodzillaVsKong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budgetMovie = Double.parseDouble(scanner.nextLine());
        int extraActor = Integer.parseInt(scanner.nextLine());
        double costumePrice = Double.parseDouble(scanner.nextLine());

        double totalPrice = 0;

        if (extraActor > 150) {
            totalPrice = costumePrice * extraActor - (costumePrice * extraActor) * 0.10 + budgetMovie * 0.10;
        } else {
            totalPrice = costumePrice * extraActor + budgetMovie * 0.10;
        }
        if (totalPrice > budgetMovie) {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", totalPrice - budgetMovie);
        } else {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", budgetMovie - totalPrice);
        }
    }
}