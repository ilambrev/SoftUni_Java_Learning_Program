package forLoop;

import java.util.Scanner;

public class P05CharacterSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int length = text.length();

        for (int i = 0; i < length; i++) {
            char letter = text.charAt(i);
            System.out.println(letter);
        }
    }
}