package NestedLoops;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")) {
            double tripBudget = Double.parseDouble(scanner.nextLine());
            double savedMoney = 0;
            while (savedMoney < tripBudget) {
                double money = Double.parseDouble(scanner.nextLine());
                savedMoney = savedMoney + money;
                if (savedMoney >= tripBudget) {
                    System.out.printf("Going to %s!%n", destination);
                    break;
                }
            }
            destination = scanner.nextLine();
        }
    }
}