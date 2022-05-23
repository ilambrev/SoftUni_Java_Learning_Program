package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05BalancedParentheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String sequence = scanner.nextLine();

        char firstBracket = sequence.charAt(0);

        String result = "YES";

        if (sequence.length() % 2 != 0 || (firstBracket == ')' || firstBracket == ']' || firstBracket == '}')) {
            result = "NO";
        } else {

            ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

            for (int i = 0; i < sequence.length(); i++) {
                char bracket = sequence.charAt(i);
                if (bracket == '(' || bracket == '[' || bracket == '{') {
                    openingBrackets.push(bracket);
                } else if (!matchingBrackets(openingBrackets, bracket)) {
                    result = "NO";
                    break;
                }
            }
            if (!openingBrackets.isEmpty()) {
                result = "NO";
            }
        }

        System.out.println(result);
    }

    public static boolean matchingBrackets(ArrayDeque<Character> openingBracket, char closingBracket) {
        if (!openingBracket.isEmpty()) {
            char currentBracket = openingBracket.pop();
            return ((currentBracket == '(' && closingBracket == ')') ||
                    (currentBracket == '[' && closingBracket == ']') ||
                    (currentBracket == '{' && closingBracket == '}'));
        } else {
            return false;
        }
    }

}