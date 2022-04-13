package ME02DataTypesAndVariables;

import java.util.Scanner;

public class ME01DataTypeFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean isInteger = false;
        boolean isDouble = false;

        while (!input.equals("END")) {
            int decimalPointCounter = 0;
            if ((input.charAt(0) == '-' || input.charAt(0) == '+') && input.length() > 1) {
                for (int i = 1; i < input.length(); i++) {
                    isInteger = input.charAt(i) >= '0' && input.charAt(i) <= '9';
                    if (!isInteger) {
                        break;
                    }
                }
                for (int i = 1; i < input.length(); i++) {
                    isDouble = (input.charAt(i) >= '0' && input.charAt(i) <= '9');
                    if (input.charAt(i) == '.') {
                        decimalPointCounter++;
                        isDouble = true;
                    }
                    if (!isDouble || decimalPointCounter > 1) {
                        isDouble = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < input.length(); i++) {
                    isInteger = input.charAt(i) >= '0' && input.charAt(i) <= '9';
                    if (!isInteger) {
                        break;
                    }
                }
                for (int i = 0; i < input.length(); i++) {
                    isDouble = (input.charAt(i) >= '0' && input.charAt(i) <= '9');
                    if (input.charAt(i) == '.') {
                        decimalPointCounter++;
                        isDouble = true;
                    }
                    if (!isDouble || decimalPointCounter > 1) {
                        isDouble = false;
                        break;
                    }
                }
            }

            if (isInteger) {
                System.out.printf("%s is integer type%n", input);
            } else if (isDouble) {
                System.out.printf("%s is floating point type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }
            input = scanner.nextLine();
        }
    }
}