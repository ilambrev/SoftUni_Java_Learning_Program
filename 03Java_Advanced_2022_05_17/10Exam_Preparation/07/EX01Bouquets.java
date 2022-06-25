package EX07RetakeExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EX01Bouquets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] daffodilsInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] tulipsInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> daffodils = new ArrayDeque<>();

        Deque<Integer> tulips = new ArrayDeque<>();

        for (Integer d : daffodilsInput) {
            daffodils.offer(d);
        }

        for (Integer t : tulipsInput) {
            tulips.push(t);
        }

        int bouquets = 0;
        int storedFlowers = 0;

        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int daffodilsFlowers = daffodils.poll();
            int tulipsFlowers = tulips.pop();
            int flowers = daffodilsFlowers + tulipsFlowers;

            if (flowers > 15) {
                while (flowers > 15) {
                    tulipsFlowers -= 2;
                    flowers -= 2;
                }
            }
            if (flowers == 15) {
                bouquets++;
            } else {
                storedFlowers += flowers;
            }
        }

        bouquets += storedFlowers / 15;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }

    }
}