package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E04BasicQueueOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("\\s+");

        int elementsToAdd = Integer.parseInt(commands[0]);
        int elementsToRemove = Integer.parseInt(commands[1]);
        int elementToCheck = Integer.parseInt(commands[2]);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < elementsToAdd; i++) {
            numbers.offer(array[i]);
        }

        for (int i = 1; i <= elementsToRemove; i++) {
            numbers.poll();
        }

        boolean isElementPresent = false;
        int minElement = Integer.MAX_VALUE;

        for (Integer number : numbers) {
            if (number == elementToCheck) {
                isElementPresent = true;
                break;
            } else if (number < minElement) {
                minElement = number;
            }
        }

        System.out.println(numbers.isEmpty() ? 0 : isElementPresent ? "true" : minElement);
    }
}