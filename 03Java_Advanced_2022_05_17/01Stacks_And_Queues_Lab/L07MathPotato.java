package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L07MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] childrenInGame = scanner.nextLine().split("\\s+");
        int tosses = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();

        for (String childName : childrenInGame) {
            children.offer(childName);
        }

        int cyclesCounter = 1;

        while (children.size() > 1) {
            for (int i = 1; i < tosses; i++) {
                String childTurn = children.poll();
                if (childTurn != null) {
                    children.offer(childTurn);
                }
            }
            if (isPrime(cyclesCounter)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }
            cyclesCounter++;
        }
        System.out.println("Last is " + children.peek());
    }

    public static boolean isPrime(int cyclesCounter) {
        if (cyclesCounter < 2) {
            return false;
        } else {
            for (int i = 2; i < cyclesCounter; i++) {
                if (cyclesCounter % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}