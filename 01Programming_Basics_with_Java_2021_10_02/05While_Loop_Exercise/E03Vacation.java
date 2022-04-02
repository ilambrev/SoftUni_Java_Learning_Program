package e05WhileLoop;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tripMoney = Double.parseDouble(scanner.nextLine());
        double onHandMoney = Double.parseDouble(scanner.nextLine());

        int saveDays =0;
        int spendDays = 0;

        while (onHandMoney < tripMoney) {
            if (spendDays >= 5) {
                System.out.printf("You can't save the money.%n");
                System.out.println(saveDays);
                break;
            }
            String moneyOperation = scanner.nextLine();
            double currentSum = Double.parseDouble(scanner.nextLine());
            if (moneyOperation.equals("spend")) {
                onHandMoney = onHandMoney - currentSum;
                if (onHandMoney < 0) {
                    onHandMoney = 0;
                }
                spendDays ++;
            } else if (moneyOperation.equals("save")) {
                onHandMoney = onHandMoney + currentSum;
                spendDays = 0;
            }
            saveDays ++;
        }
        if (onHandMoney >= tripMoney) {
            System.out.printf("You saved the money for %d days.", saveDays);
        }
    }
}