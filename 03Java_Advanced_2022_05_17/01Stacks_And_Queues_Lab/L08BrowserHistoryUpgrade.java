package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L08BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String instruction = scanner.nextLine();

        ArrayDeque<String> backAddresses = new ArrayDeque<>();
        ArrayDeque<String> forwardAddresses = new ArrayDeque<>();

        String currentURL = null;

        while (!"Home".equals(instruction)) {
            if ("back".equals(instruction)) {
                if (!backAddresses.isEmpty()) {
                    if (currentURL != null) {
                        forwardAddresses.push(currentURL);
                    }
                    currentURL = backAddresses.peek();
                    System.out.println(backAddresses.pop());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals((instruction))) {
                if (!forwardAddresses.isEmpty()) {
                    currentURL = forwardAddresses.peek();
                    System.out.println(forwardAddresses.pop());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                if (currentURL != null) {
                    backAddresses.push(currentURL);
                }
                currentURL = instruction;
                System.out.println(instruction);
                forwardAddresses.clear();
            }
            instruction = scanner.nextLine();
        }
    }
}