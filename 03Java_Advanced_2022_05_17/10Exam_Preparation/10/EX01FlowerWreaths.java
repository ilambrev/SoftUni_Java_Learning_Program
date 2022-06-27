package EX10RetakeExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EX01FlowerWreaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] liliesInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] rosesInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> lilies = new ArrayDeque<>();

        Deque<Integer> roses = new ArrayDeque<>();

        for (Integer lilie : liliesInput) {
            lilies.push(lilie);
        }

        for (Integer rose : rosesInput) {
            roses.offer(rose);
        }

        int wreaths = 0;
        int storedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int numberOfRoses = roses.poll();
            int numberOfLilies = lilies.pop();
            int amountOfFlowers = numberOfRoses + numberOfLilies;
            if (amountOfFlowers > 15) {
                while (numberOfLilies > 15) {
                    numberOfLilies -= 2;
                    amountOfFlowers -= 2;
                }
            }
            if (amountOfFlowers < 15) {
                storedFlowers += amountOfFlowers;
            } else {
                wreaths++;
            }

        }

        wreaths += storedFlowers / 15;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }

    }
}