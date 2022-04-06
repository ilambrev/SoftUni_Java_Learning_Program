package E2020_03_28And29;

import java.util.Scanner;

public class P04FoodForPets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double foodAmount = Double.parseDouble(scanner.nextLine());

        double biscuitAmount = 0.0;
        double eatenFood = 0.0;
        double eatenDogFood = 0.0;
        double eatenCatFood = 0.0;

        for (int i = 1; i <= days; i++) {
            double dogFood = Double.parseDouble(scanner.nextLine());
            double catFood = Double.parseDouble(scanner.nextLine());
            eatenDogFood = eatenDogFood + dogFood;
            eatenCatFood = eatenCatFood + catFood;
            if (i % 3 == 0) {
                biscuitAmount = biscuitAmount + 0.1 * dogFood + 0.1 * catFood;
            }
        }
        eatenFood = eatenDogFood + eatenCatFood;
        System.out.printf("Total eaten biscuits: %dgr.%n", Math.round(biscuitAmount));
        System.out.printf("%.2f%% of the food has been eaten.%n", eatenFood / foodAmount * 100);
        System.out.printf("%.2f%% eaten from the dog.%n", eatenDogFood / eatenFood * 100);
        System.out.printf("%.2f%% eaten from the cat.%n", eatenCatFood / eatenFood * 100);
    }
}