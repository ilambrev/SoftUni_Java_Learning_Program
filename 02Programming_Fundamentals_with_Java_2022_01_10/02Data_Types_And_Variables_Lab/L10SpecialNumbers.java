package L02DataTypesAndVariables;

import java.util.Scanner;

public class L10SpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            int sumOfDigits = 0;
            while (currentNumber != 0) {
                int digit = currentNumber % 10;
                sumOfDigits += digit;
                currentNumber /= 10;
            }
            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}