package E08TextProcessing;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class E08LettersChangeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        BigDecimal sum = new BigDecimal("0.00");

        for (String string : strings) {
            int number = Integer.parseInt(string.substring(1, string.length() - 1));
            if (string.charAt(0) >= 'A' && string.charAt(0) <= 'Z') {
                sum = sum.add(BigDecimal.valueOf(number).divide(BigDecimal.valueOf(string.charAt(0) - 64), new MathContext(16)));
            }
            if (string.charAt(0) >= 'a' && string.charAt(0) <= 'z') {
                sum = sum.add(BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(string.charAt(0) - 96)));
            }
            if (string.charAt(string.length() - 1) >= 'A' && string.charAt(string.length() - 1) <= 'Z') {
                sum = sum.subtract(BigDecimal.valueOf(string.charAt(string.length() - 1) - 64));
            }
            if (string.charAt(string.length() - 1) >= 'a' && string.charAt(string.length() - 1) <= 'z') {
                sum = sum.add(BigDecimal.valueOf(string.charAt(string.length() - 1) - 96));
            }
        }

        System.out.printf("%.2f", sum);
    }
}