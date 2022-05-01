package E08TextProcessing;

import java.util.Scanner;

public class E05MultiplyBigNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder multiplicand = new StringBuilder().append(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        while (multiplicand.length() > 1 && multiplicand.charAt(0) == '0') {
            multiplicand.deleteCharAt(0);
        }

        StringBuilder result = new StringBuilder();

        int transmission = 0;
        if (multiplier > 0) {
            for (int i = multiplicand.length() - 1; i >= 0; i--) {

                int number = Integer.parseInt(String.valueOf(multiplicand.charAt(i)));
                int currentResult = number * multiplier + transmission;
                int digit = currentResult % 10;
                transmission = currentResult / 10;
                result.insert(0, digit);
            }
        } else {
            result.insert(0, "0");
        }
        if (transmission > 0) {
            result.insert(0, transmission);
        }

        System.out.println(result);
    }
}