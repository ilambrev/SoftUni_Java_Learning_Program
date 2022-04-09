package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E02Division {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int highDivisor = 0;

        for (int i = 1; i <= 10; i++) {
            if ((number % i == 0) && (i == 2 || i == 3 || i == 6 || i == 7 || i == 10)) {
                highDivisor = i;
            }
        }
        if (highDivisor == 0) {
            System.out.println("Not divisible");
        } else {
            System.out.println("The number is divisible by " + highDivisor);
        }
    }
}