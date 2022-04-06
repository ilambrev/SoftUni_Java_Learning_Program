package E2020_03_28And29;

import java.util.Scanner;

public class P02CatWalking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int minutes = Integer.parseInt(scanner.nextLine());
        int walkNumber = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());

        double burnCalories = minutes * 5 * walkNumber;

        if (burnCalories >= 0.5 * calories) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", burnCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", burnCalories);
        }
    }
}