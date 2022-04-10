package ME01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class ME05Messages {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numOfLetters = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numOfLetters; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            int mainDigit = currentNum % 10;
            int numberOfDigits = 0;
            int offset = 0;
            if (currentNum == 0) {
                System.out.print(" ");
            } else {
                while (currentNum > 0) {
                    if ((currentNum % 10) > 0) {
                        currentNum = currentNum / 10;
                        numberOfDigits = numberOfDigits + 1;
                    }
                }
                if (mainDigit == 8 || mainDigit == 9) {
                    offset = (mainDigit - 2) * 3 +1;
                } else {
                    offset = (mainDigit - 2) * 3;
                }
                int letterIndex = offset + numberOfDigits - 1;
                char letter = (char) (letterIndex + 97);
                System.out.print(letter);
            }
        }
    }
}