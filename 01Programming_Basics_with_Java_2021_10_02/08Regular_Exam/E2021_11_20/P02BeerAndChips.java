package E2021_11_20;

import java.util.Scanner;

public class P02BeerAndChips {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String footballFanName = scanner.nextLine();
        double fanBudget = Double.parseDouble(scanner.nextLine());
        int beerBottles = Integer.parseInt(scanner.nextLine());
        int chipsPacks = Integer.parseInt(scanner.nextLine());

        double totalPrice = beerBottles * 1.20 + Math.ceil((chipsPacks * beerBottles * 1.20) * 0.45);

        if (totalPrice <= fanBudget) {
            System.out.printf("%s bought a snack and has %.2f leva left.", footballFanName, fanBudget - totalPrice);
        } else {
            System.out.printf("%s needs %.2f more leva!", footballFanName, totalPrice - fanBudget);
        }
    }
}