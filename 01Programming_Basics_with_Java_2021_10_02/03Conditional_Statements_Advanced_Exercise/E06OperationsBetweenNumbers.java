package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E06OperationsBetweenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        String sign = scanner.nextLine();
        double result = 0.0;

        if (sign.equals("+")) {
            result = N1 + N2;
            if (result % 2 == 0) {
                System.out.printf("%d %s %d = %.0f - even", N1, sign, N2, result);
            } else {
                System.out.printf("%d %s %d = %.0f - odd", N1, sign, N2, result);
            }
        } else if (sign.equals("-")) {
            result = N1 - N2;
            if (result % 2 == 0) {
                System.out.printf("%d %s %d = %.0f - even", N1, sign, N2, result);
            } else {
                System.out.printf("%d %s %d = %.0f - odd", N1, sign, N2, result);
            }
        } else if (sign.equals("*")) {
            result = N1 * N2;
            if (result % 2 == 0) {
                System.out.printf("%d %s %d = %.0f - even", N1, sign, N2, result);
            } else {
                System.out.printf("%d %s %d = %.0f - odd", N1, sign, N2, result);
            }
        } else if (sign.equals("/")) {
            if (N2 == 0) {
                System.out.printf("Cannot divide %d by zero", N1);
            } else {
                result = N1 * 1.0 / N2;
                System.out.printf("%d %s %d = %.2f", N1, sign, N2, result);
            }
        } else if (sign.equals("%")) {
            if (N2 == 0) {
                System.out.printf("Cannot divide %d by zero", N1);
            } else {
                result = N1 % N2;
                System.out.printf("%d %s %d = %.0f", N1, sign, N2, result);
            }
        }
    }
}