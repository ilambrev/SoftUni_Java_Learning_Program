package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L06HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] childrenInGame = scanner.nextLine().split("\\s+");
        int tosses = Integer.parseInt(scanner.nextLine());


        ArrayDeque<String> children = new ArrayDeque<>();

        for (String childName : childrenInGame) {
            children.offer(childName);
        }

        while (children.size() > 1) {
            for (int i = 1; i < tosses; i++) {
                String childTurn = children.poll();
                if (childTurn != null) {
                    children.offer(childTurn);
                }
            }
            System.out.println("Removed " + children.poll());
        }
        System.out.println("Last is " + children.peek());
    }
}