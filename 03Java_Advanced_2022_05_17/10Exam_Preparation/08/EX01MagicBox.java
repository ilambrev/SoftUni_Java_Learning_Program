package EX08Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EX01MagicBox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstMagicBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondMagicBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> firstMagicBox = new ArrayDeque<>();

        Deque<Integer> secondMagicBox = new ArrayDeque<>();

        for (Integer item : firstMagicBoxInput) {
            firstMagicBox.offer(item);
        }

        for (Integer item : secondMagicBoxInput) {
            secondMagicBox.push(item);
        }

        int claimedItems = 0;

        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int itemFromFirstBox = firstMagicBox.peek();
            int itemFromSecondBox = secondMagicBox.pop();
            int twoItems = itemFromFirstBox + itemFromSecondBox;

            if (twoItems % 2 == 0) {
                claimedItems += twoItems;
                firstMagicBox.poll();
            } else {
                firstMagicBox.offer(itemFromSecondBox);
            }
        }

        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }

        if (secondMagicBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }


    }
}