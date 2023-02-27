package E2021_11_13;

import java.util.Scanner;

public class P02FootballKit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tshirtPrice = Double.parseDouble(scanner.nextLine());
        double sumForPresent = Double.parseDouble(scanner.nextLine());

        double shortsPrice = 0.75 * tshirtPrice;
        double socksPrice = 0.20 * shortsPrice;
        double footballShoesPrice = 2 * (tshirtPrice + shortsPrice);

        double totalSum = (tshirtPrice + shortsPrice + socksPrice + footballShoesPrice) * 0.85;

        if (totalSum >= sumForPresent) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", totalSum);
        } else {
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", sumForPresent - totalSum);
        }

    }
}