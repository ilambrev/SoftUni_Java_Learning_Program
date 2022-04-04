package e06NestedLoops;

import java.util.Scanner;

public class E02EqualSumsEvenOddPosition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        int evenSum = 0;
        int oddSum = 0;

        for (int i = n1; i <= n2; i++) {
            int currentNum = i;
            for (int j = 6; j >= 1; j--) {
                int currentDigit = currentNum % 10;
                if (j % 2 == 0) {
                    evenSum = evenSum + currentDigit;
                } else {
                    oddSum = oddSum + currentDigit;
                }
                currentNum = currentNum / 10;
            }
            if (evenSum == oddSum) {
                System.out.printf("%d ", i);
            }
            evenSum = 0;
            oddSum = 0;
        }
    }
}