package EX06FinalExamRetake2019PartI;

import java.util.Scanner;

public class EX01SantasCookies {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int batchesAmount = Integer.parseInt(scanner.nextLine());

        int boxesOfCookies = 0;
        for (int i = 1; i <= batchesAmount; i++) {
            int flourInGrams = Integer.parseInt(scanner.nextLine());
            int sugarInGrams = Integer.parseInt(scanner.nextLine());
            int cocoaInGrams = Integer.parseInt(scanner.nextLine());
            if (flourInGrams < 140 || sugarInGrams < 20 || cocoaInGrams < 10) {
                System.out.println("Ingredients are not enough for a box of cookies.");
            } else {
                int cups = flourInGrams / 140;
                int smallSpoons = cocoaInGrams / 10;
                int bigSpoons = sugarInGrams / 20;
                int[] items = new int[]{cups, smallSpoons, bigSpoons};
                int amountOfIngredients = Integer.MAX_VALUE;
                for (int j = 0; j < items.length; j++) {
                    if (items[j] < amountOfIngredients) {
                        amountOfIngredients = items[j];
                    }
                }
                int numberOfCookies = (amountOfIngredients * (140 + 10 + 20)) / 25;
                if (numberOfCookies > 5) {
                    int boxesOfCookiesPerCurrentBake = numberOfCookies / 5;
                    System.out.println("Boxes of cookies: " + boxesOfCookiesPerCurrentBake);
                    boxesOfCookies += boxesOfCookiesPerCurrentBake;
                }
            }
        }
        System.out.println("Total boxes: " + boxesOfCookies);
    }
}