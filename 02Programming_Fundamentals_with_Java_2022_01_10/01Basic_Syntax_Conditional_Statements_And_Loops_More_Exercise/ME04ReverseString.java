package ME01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class ME04ReverseString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String stringToReverse = scanner.nextLine();

        int stringLength = stringToReverse.length();
        String reversedString = "";

        for (int i = stringLength-1; i >= 0; i--) {
            char currentSymbol = stringToReverse.charAt(i);
            reversedString = reversedString + currentSymbol;
        }
        System.out.println(reversedString);
    }
}