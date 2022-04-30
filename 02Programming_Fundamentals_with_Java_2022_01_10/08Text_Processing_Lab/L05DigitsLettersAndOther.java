package L08TextProcessing;

import java.util.Scanner;

public class L05DigitsLettersAndOther {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        StringBuilder[] resultStrings = new StringBuilder[]{new StringBuilder(), new StringBuilder(), new StringBuilder()};

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') {
                resultStrings[0].append(inputString.charAt(i));
            } else if ((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z') || (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z')) {
                resultStrings[1].append(inputString.charAt(i));
            } else {
                resultStrings[2].append(inputString.charAt(i));
            }
        }

        for (StringBuilder s : resultStrings) {
            System.out.println(s);
        }

    }
}