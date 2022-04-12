package E02DataTypesAndVariables;

import java.util.Scanner;

public class E04SumOfChars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLetters = Integer.parseInt(scanner.nextLine());
        int sumOfLettersCodes = 0;

        for (int i = 1; i <= numberOfLetters; i++) {
            char letter = scanner.nextLine().charAt(0);
            sumOfLettersCodes += letter;
        }
        System.out.println("The sum equals: " + sumOfLettersCodes);
    }
}