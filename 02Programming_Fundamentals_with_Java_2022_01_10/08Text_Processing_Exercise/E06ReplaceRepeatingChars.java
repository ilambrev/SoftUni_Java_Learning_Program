package E08TextProcessing;

import java.util.Scanner;

public class E06ReplaceRepeatingChars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder().append(scanner.nextLine());

        for (int i = input.length() - 1; i > 0; i--) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                input.deleteCharAt(i);
            }
        }

        System.out.println(input);
    }
}