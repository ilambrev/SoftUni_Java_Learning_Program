package E04Methods;

import java.util.Scanner;

public class E09PalindromeIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            findPalindrome(input);
            input = scanner.nextLine();
        }
    }

    public static void findPalindrome(String input) {
        String[] number = input.split("");
        for (int i = 0; i < number.length / 2; i++) {
            String currentElement = number[i];
            number[i] = number[number.length - 1 - i];
            number[number.length - 1 - i] = currentElement;
        }
        String reversedNumber = "";
        for (int i = 0; i < number.length; i++) {
            reversedNumber += number[i];
        }
        if (reversedNumber.equals(input)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}