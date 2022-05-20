package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String instruction = scanner.nextLine();

        ArrayDeque<String> addresses = new ArrayDeque<>();

        String currentURL = null;

        while (!"Home".equals(instruction)) {
            if ("back".equals(instruction)) {
                if (!addresses.isEmpty()) {
                    currentURL = addresses.peek();
                    System.out.println(addresses.pop());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                if (currentURL != null) {
                    addresses.push(currentURL);
                }
                currentURL = instruction;
                System.out.println(instruction);
            }
            instruction = scanner.nextLine();
        }

    }
}