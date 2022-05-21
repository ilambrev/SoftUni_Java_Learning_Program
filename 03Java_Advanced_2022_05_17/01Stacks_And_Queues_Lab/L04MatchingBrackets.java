package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L04MatchingBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputExpression = scanner.nextLine();

        ArrayDeque<Integer> bracketsIndices = new ArrayDeque<>();

        for (int i = 0; i < inputExpression.length(); i++) {
            char currentSymbol = inputExpression.charAt(i);
            if (currentSymbol == '(') {
                bracketsIndices.push(i);
            } else if (currentSymbol == ')') {
                int beginIndex = bracketsIndices.pop();
                String subExpression = inputExpression.substring(beginIndex, i + 1);
                System.out.println(subExpression);
            }
        }

    }
}