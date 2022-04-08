package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class L09SumOfOddNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int numberCounter = 0;
        int sum = 0;

        for (int i = 1; numberCounter < n; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                numberCounter++;
                sum += i;
            }
        }
        System.out.println("Sum: " + sum);
    }
}