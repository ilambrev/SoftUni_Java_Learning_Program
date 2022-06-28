package EX12Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EX01Lootbox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> firstBox = new ArrayDeque<>();

        for (Integer item : firstBoxInput) {
            firstBox.offer(item);
        }

        Deque<Integer> secondBox = new ArrayDeque<>();

        for (Integer item : secondBoxInput) {
            secondBox.push(item);
        }

        int sumOfClaimedItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek();
            int secondItem = secondBox.pop();
            int sumOfItems = firstItem + secondItem;

            if (sumOfItems % 2 == 0) {
                sumOfClaimedItems += sumOfItems;
                firstBox.poll();
            } else {
                firstBox.offer(secondItem);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (sumOfClaimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumOfClaimedItems);
        }

    }
}