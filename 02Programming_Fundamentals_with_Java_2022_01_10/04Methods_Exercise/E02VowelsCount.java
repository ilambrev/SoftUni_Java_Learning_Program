package E04Methods;

import java.util.Scanner;

public class E02VowelsCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        countVowels(inputText);
    }

    public static void countVowels(String inputText) {
        int numberOfVowels = 0;
        for (int i = 0; i < inputText.length(); i++) {
            char letter = Character.toUpperCase(inputText.charAt(i));
            if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
                numberOfVowels++;
            }
        }
        System.out.println(numberOfVowels);
    }

}