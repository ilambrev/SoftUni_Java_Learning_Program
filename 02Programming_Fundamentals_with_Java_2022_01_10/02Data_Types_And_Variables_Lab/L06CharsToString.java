package L02DataTypesAndVariables;

import java.util.Scanner;

public class L06CharsToString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder resultString = new StringBuilder();

        for (int i = 1; i <= 3; i++) {
            char letter = scanner.nextLine().charAt(0);
            resultString.append(letter);
        }
        System.out.println(resultString);
    }
}