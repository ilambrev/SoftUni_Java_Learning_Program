package e06NestedLoops;

import java.util.Scanner;

public class E03SumPrimeNonPrime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputNumber = scanner.nextLine();

        int primeSum = 0;
        int nonPrimeSum = 0;

        while (!inputNumber.equals("stop")) {
            int currentNum = Integer.parseInt(inputNumber);
            if (currentNum < 0) {
                System.out.println("Number is negative.");
                inputNumber = scanner.nextLine();
                continue;
            }
            boolean isValid = false;
            for (int i = 2; i <= currentNum - 1; i++) {
                if (currentNum % i == 0) {
                    isValid = true;
                    break;
                }
            }
            if (isValid) {
                nonPrimeSum = nonPrimeSum + currentNum;
            } else {
                primeSum = primeSum + currentNum;
            }
            inputNumber = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrimeSum);
    }
}