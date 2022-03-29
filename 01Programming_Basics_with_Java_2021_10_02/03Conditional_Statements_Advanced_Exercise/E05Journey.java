package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E05Journey {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double spentSum = 0;
        String destination = "";
        String type = "";

        if (budget <= 100) {
            if (season.equals("summer")) {
                spentSum = budget * 0.30;
                destination = "Bulgaria";
                type = "Camp";
            } else if (season.equals("winter")) {
                spentSum = budget * 0.70;
                destination = "Bulgaria";
                type = "Hotel";
            }

        } else if (budget <= 1000) {
            if (season.equals("summer")) {
                spentSum = budget * 0.40;
                destination = "Balkans";
                type = "Camp";
            } else if (season.equals("winter")) {
                spentSum = budget * 0.80;
                destination = "Balkans";
                type = "Hotel";
            }
        } else {
            spentSum = budget * 0.90;
            destination = "Europe";
            type = "Hotel";
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", type, spentSum);
    }
}