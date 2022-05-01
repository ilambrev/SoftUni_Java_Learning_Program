package E08TextProcessing;

import java.util.Scanner;

public class E04CaesarCipher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        StringBuilder encodedText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            encodedText.append((char) (inputText.charAt(i) + 3));
        }

        System.out.println(encodedText);
    }
}