package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E06StrongNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int processedNumber = number;
        int sum = 0;

        if (number == 0) {
            sum = sum + 1;
        }

        while (processedNumber > 0) {
            int digit = processedNumber % 10;
            int digitFactorial = 1;
            if (digit == 0) {
                sum = sum + 1;
            } else {
                for (int i = digit; i > 0; i--) {
                    digitFactorial = digitFactorial * i;
                }
                sum += digitFactorial;
            }
            processedNumber = processedNumber / 10;
        }
        if (number == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}