package L04Methods;

import java.util.Scanner;

public class L07RepeatString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        int repeatsNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(inputString, repeatsNumber));
    }

    public static String repeatString(String initialString, int numberOfRepeats) {
        String resultString = "";
        for (int i = 1; i <= numberOfRepeats; i++) {
            resultString += initialString;
        }
        return resultString;
    }

}