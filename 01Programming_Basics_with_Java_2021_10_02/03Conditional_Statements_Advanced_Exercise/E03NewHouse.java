package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E03NewHouse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int flowersNumber = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;

        switch (flowerType) {
            case "Roses":
                if (flowersNumber > 80) {
                    totalSum = (flowersNumber * 5.00) * 0.90;
                } else
                    totalSum = flowersNumber * 5.00;
                break;
            case "Dahlias":
                if (flowersNumber > 90) {
                    totalSum = (flowersNumber * 3.80) * 0.85;
                } else
                    totalSum = flowersNumber * 3.80;
                break;
            case "Tulips":
                if (flowersNumber > 80) {
                    totalSum = (flowersNumber * 2.80) * 0.85;
                } else
                    totalSum = flowersNumber * 2.80;
                break;
            case "Narcissus":
                if (flowersNumber < 120) {
                    totalSum = (flowersNumber * 3.00) * 1.15;
                } else
                    totalSum = flowersNumber * 3.00;
                break;
            case "Gladiolus":
                if (flowersNumber < 80) {
                    totalSum = (flowersNumber * 2.50) * 1.20;
                } else
                    totalSum = flowersNumber * 2.50;
                break;
        }
        if (budget >= totalSum) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersNumber, flowerType, budget - totalSum);
        } else
            System.out.printf("Not enough money, you need %.2f leva more.", totalSum - budget);
    }
}