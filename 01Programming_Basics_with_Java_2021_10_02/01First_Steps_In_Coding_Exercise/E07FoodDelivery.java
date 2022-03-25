package e01FirstSteps;

import java.util.Scanner;

public class E07FoodDelivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int chickenMenus = Integer.parseInt(scanner.nextLine());
        int fishMenus = Integer.parseInt(scanner.nextLine());
        int veganMenus = Integer.parseInt(scanner.nextLine());

        double price = chickenMenus * 10.35 + fishMenus * 12.40 + veganMenus * 8.15;

        System.out.println(price + 0.2 * price + 2.5);
    }
}