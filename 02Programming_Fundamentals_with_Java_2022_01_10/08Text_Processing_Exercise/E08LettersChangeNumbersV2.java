package E08TextProcessing;

import java.util.Scanner;

public class E08LettersChangeNumbersV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String string : strings) {
            double number = Double.parseDouble(string.substring(1, string.length() - 1));
            if (string.charAt(0) >= 'A' && string.charAt(0) <= 'Z') {
                sum += number / (string.charAt(0) - 64);
            }
            if (string.charAt(0) >= 'a' && string.charAt(0) <= 'z') {
                sum += number * (string.charAt(0) - 96);
            }
            if (string.charAt(string.length() - 1) >= 'A' && string.charAt(string.length() - 1) <= 'Z') {
                sum -= (string.charAt(string.length() - 1) - 64);
            }
            if (string.charAt(string.length() - 1) >= 'a' && string.charAt(string.length() - 1) <= 'z') {
                sum += (string.charAt(string.length() - 1) - 96);
            }
        }

        System.out.printf("%.2f", sum);
    }
}