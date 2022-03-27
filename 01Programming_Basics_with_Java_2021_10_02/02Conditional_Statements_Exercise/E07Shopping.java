package e02ConditionalStatements;

import java.util.Scanner;

public class E07Shopping {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budgetPeter = Double.parseDouble(scanner.nextLine());
        int vcardNum = Integer.parseInt(scanner.nextLine());
        int cpuNum  = Integer.parseInt(scanner.nextLine());
        int ramNum = Integer.parseInt(scanner.nextLine());

        double vcardPrice = vcardNum * 250;
        double totalPrice = vcardPrice + cpuNum * vcardPrice * 0.35 + ramNum * vcardPrice * 0.10;

        if (vcardNum > cpuNum) {
            totalPrice = totalPrice - totalPrice * 0.15;
        }
        if (totalPrice <= budgetPeter) {
            System.out.printf("You have %.2f leva left!", budgetPeter - totalPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - budgetPeter);
        }
    }
}