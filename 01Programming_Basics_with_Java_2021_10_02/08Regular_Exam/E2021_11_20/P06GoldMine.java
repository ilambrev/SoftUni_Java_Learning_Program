package E2021_11_20;

import java.util.Scanner;

public class P06GoldMine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int locationNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= locationNumber; i++) {
            double goldExtractionExpected = Double.parseDouble(scanner.nextLine());
            int daysForExtraction = Integer.parseInt(scanner.nextLine());
            double goldExtraction = 0;
            for (int j = 1; j <= daysForExtraction; j++) {
                double goldPerDay = Double.parseDouble(scanner.nextLine());
                goldExtraction = goldExtraction + goldPerDay;
            }
            double goldExtractionPerDay = goldExtraction /daysForExtraction;
            if (goldExtractionPerDay >= goldExtractionExpected) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", goldExtractionPerDay);
            } else {
                System.out.printf("You need %.2f gold.%n", goldExtractionExpected - goldExtractionPerDay);
            }
        }
    }
}