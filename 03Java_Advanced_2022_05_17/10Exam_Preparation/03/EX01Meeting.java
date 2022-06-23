package EX03RetakeExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX01Meeting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] malesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] femalesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> males = new ArrayDeque<>();
        Deque<Integer> females = new ArrayDeque<>();

        for (Integer male : malesInput) {
            males.push(male);
        }

        for (Integer female : femalesInput) {
            females.offer(female);
        }

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();

            if (male <= 0) {
                males.pop();
                continue;
            }

            if (female <= 0) {
                females.poll();
                continue;
            }

            if (male % 25 == 0) {
                males.pop();
                if (!males.isEmpty()) {
                    males.pop();
                }
                continue;
            }

            if (female % 25 == 0) {
                females.poll();
                if (!females.isEmpty()) {
                    females.poll();
                }
                continue;
            }

            female = females.poll();
            male = males.pop();

            if (male == female) {
                matches++;
            } else {
                male -= 2;
                males.push(male);
            }

        }

        System.out.println("Matches: " + matches);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }
}