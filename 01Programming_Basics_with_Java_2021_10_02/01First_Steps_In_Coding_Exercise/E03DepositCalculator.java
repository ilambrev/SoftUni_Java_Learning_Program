package e01FirstSteps;

import java.util.Scanner;

public class E03DepositCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double deposit = Double.parseDouble(scanner.nextLine());
        int term = Integer.parseInt(scanner.nextLine());
        double interest = Double.parseDouble(scanner.nextLine());
        double sum = deposit + term * ((deposit * interest / 100) / 12);

        System.out.println(sum);
    }
}