package E2021_11_20;

import java.util.Scanner;

public class P05PuppyCare {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int foodAmountInKG = Integer.parseInt(scanner.nextLine());
        String foodAmountPerEat = scanner.nextLine();

        int foodAmountInG = foodAmountInKG * 1000;
        int foodEatenAmount = 0;

        while (!foodAmountPerEat.equals("Adopted")) {
            int currentFood = Integer.parseInt(foodAmountPerEat);
            foodEatenAmount = foodEatenAmount + currentFood;
            foodAmountPerEat = scanner.nextLine();
        }
        if (foodEatenAmount <= foodAmountInG) {
            System.out.printf("Food is enough! Leftovers: %d grams.", foodAmountInG - foodEatenAmount);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", foodEatenAmount - foodAmountInG);
        }
    }
}