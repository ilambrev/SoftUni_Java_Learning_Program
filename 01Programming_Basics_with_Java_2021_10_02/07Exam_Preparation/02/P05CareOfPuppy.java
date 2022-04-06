package E2020_03_28And29;

import java.util.Scanner;

public class P05CareOfPuppy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int foodAmountKg = Integer.parseInt(scanner.nextLine());
        String dailyFoodAmountGr = scanner.nextLine();

        int foodEaten = 0;

        int foodAmountGr = foodAmountKg * 1000;

        while (!dailyFoodAmountGr.equals("Adopted")) {
            int currentFoodPortion = Integer.parseInt(dailyFoodAmountGr);
            foodEaten = foodEaten + currentFoodPortion;
            dailyFoodAmountGr = scanner.nextLine();
        }
        if (foodEaten <= foodAmountGr) {
            System.out.printf("Food is enough! Leftovers: %d grams.", foodAmountGr - foodEaten);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", foodEaten - foodAmountGr);
        }
    }
}