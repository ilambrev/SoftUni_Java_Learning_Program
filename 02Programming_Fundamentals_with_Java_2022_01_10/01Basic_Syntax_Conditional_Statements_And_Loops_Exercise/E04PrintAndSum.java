package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E04PrintAndSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startNumber = scanner.nextInt();
        int endNumber = scanner.nextInt();

        int numbersSum = 0;

        for (int i = startNumber; i <= endNumber; i++) {
            System.out.print(i + " ");
            numbersSum += i;
        }
        System.out.println();
        System.out.println("Sum: " + numbersSum);
    }
}