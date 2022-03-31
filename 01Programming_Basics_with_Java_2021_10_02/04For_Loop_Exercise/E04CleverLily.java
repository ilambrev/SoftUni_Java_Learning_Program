package e04ForLoop;

import java.util.Scanner;

public class E04CleverLily {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double toyTotalSum = 0;
        double moneySum = 0;
        int birthDayRiceSum = 0;
        double totalSum = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                moneySum = moneySum + 9 + birthDayRiceSum;
                birthDayRiceSum = birthDayRiceSum + 10;
            } else {
                toyTotalSum = toyTotalSum + toyPrice;
            }
        }
        totalSum = toyTotalSum + moneySum;
        if (totalSum >= washingMachinePrice) {
            System.out.printf("Yes! %.2f", totalSum - washingMachinePrice);
        } else {
            System.out.printf("No! %.2f", washingMachinePrice - totalSum);
        }
    }
}