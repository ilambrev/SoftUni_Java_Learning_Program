package ME02DataTypesAndVariables;

import java.util.Scanner;

public class ME02FromLeftToTheRight {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfIterations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfIterations; i++) {
            long leftNumber = 0;
            long rightNumber = 0;
            String inputString = scanner.nextLine();
            String bufferString = "";
            for (int j = 0; j < inputString.length(); j++) {
                if (inputString.charAt(j) == ' ') {
                    leftNumber = Long.parseLong(bufferString);
                    bufferString = "";
                    for (int k = j + 1 ; k < inputString.length(); k++) {
                        bufferString += inputString.charAt(k);
                    }
                    rightNumber = Long.parseLong(bufferString);
                    break;
                } else {
                    bufferString += inputString.charAt(j);
                }
            }
            int sumOfDigits = 0;
            if (leftNumber >= rightNumber) {
                while (Math.abs(leftNumber) > 0) {
                    long currentDigit = Math.abs(leftNumber % 10);
                    sumOfDigits += currentDigit;
                    leftNumber /= 10;
                }
            } else {
                while (Math.abs(rightNumber) > 0) {
                    long currentDigit = Math.abs(rightNumber % 10);
                    sumOfDigits += currentDigit;
                    rightNumber /= 10;
                }
            }
            System.out.println(sumOfDigits);
        }
    }
}