package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E08InfixToPostfix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();
        Deque<String> queue = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split(" ");

        for (String currentToken : tokens) {
            if (Character.isDigit(currentToken.charAt(0)) || Character.isAlphabetic(currentToken.charAt(0))) {
                queue.offer(currentToken);
            } else {
                if (!stack.isEmpty()) {
                    if (!currentToken.equals("(")) {
                        while (!stack.isEmpty()) {
                            String token = stack.peek();
                            if (((token.equals("+") || token.equals("-")) && (currentToken.equals("+") || currentToken.equals("-"))) ||
                                    ((token.equals("*") || token.equals("/")))) {
                                queue.offer(stack.pop());
                            } else {
                                break;
                            }
                        }
                        if (currentToken.equals(")")) {
                            while (!stack.isEmpty()) {
                                if (stack.peek().equals("(")) {
                                    stack.pop();
                                    break;
                                } else {
                                    queue.offer(stack.pop());
                                }
                            }
                        } else {
                            stack.push(currentToken);
                        }
                    } else {
                        stack.push(currentToken);
                    }
                } else {
                    stack.push(currentToken);
                }
            }
        }

        while (!stack.isEmpty()) {
            String token = stack.peek();
            if (token.equals("(")) {
                stack.pop();
            } else {
                queue.offer(stack.pop());
            }
        }

        for (String token : queue) {
            System.out.print(token + " ");
        }

    }
}