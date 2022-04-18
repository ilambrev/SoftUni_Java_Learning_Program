package E04Methods;

import java.util.Scanner;

public class E10TopNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            findTopNumbers(i);
        }
    }

    public static void findTopNumbers(int i) {
        boolean isOddDigit = false;
        if (sumOfDigits(i) % 8 == 0) {
            int Number = i;
            while (Number > 0) {
                int digit = Number % 10;
                if (digit % 2 != 0) {
                    isOddDigit = true;
                    break;
                }
                Number /= 10;
            }
            if (isOddDigit) {
                System.out.println(i);
            }
        }
    }

    public static int sumOfDigits(int i) {
        int digitsSum = 0;
        int currentNumber = i;
        while (currentNumber > 0) {
            int digit = currentNumber % 10;
            digitsSum += digit;
            currentNumber /= 10;
        }
        return digitsSum;
    }

}