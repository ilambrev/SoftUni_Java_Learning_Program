package E08TextProcessing;

import java.util.Scanner;

public class E02CharacterMultiplier {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputStrings = scanner.nextLine().split("\\s+");

        if (inputStrings[0].length() > inputStrings[1].length()) {
            String stringForChange = inputStrings[0];
            inputStrings[0] = inputStrings[1];
            inputStrings[1] = stringForChange;
        }

        int sum = 0;

        for (int i = 0; i < inputStrings[0].length(); i++) {
            sum = sum + (inputStrings[0].charAt(i) * inputStrings[1].charAt(i));
        }

        if (inputStrings[1].length() > inputStrings[0].length()) {
            for (int i = inputStrings[0].length(); i < inputStrings[1].length(); i++) {
                sum = sum + inputStrings[1].charAt(i);
            }
        }

        System.out.println(sum);
    }
}