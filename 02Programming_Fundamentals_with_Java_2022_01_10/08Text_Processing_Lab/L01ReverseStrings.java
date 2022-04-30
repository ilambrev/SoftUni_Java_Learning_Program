package L08TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class L01ReverseStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        while (!inputString.equals("end")) {
            Character[] stringChars = new Character[inputString.length()];
            for (int i = inputString.length() - 1; i >= 0; i--) {
                stringChars[(inputString.length() - 1) - i] = inputString.charAt(i);
            }
            String reversedString = Arrays.toString(stringChars).replaceAll("[,\\[\\] ]", "");
            System.out.println(inputString + " = " + reversedString);

            inputString = scanner.nextLine();
        }
    }
}