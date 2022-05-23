package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E02BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split(" ");
        int elementsToPush = Integer.parseInt(commands[0]);
        int elementsToPop = Integer.parseInt(commands[1]);
        int elementToCheck = Integer.parseInt(commands[2]);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) {
            numbers.push(array[i]);
        }

        for (int i = 1; i <= elementsToPop; i++) {
            numbers.pop();
        }

        boolean isElementPresent = false;
        int minNumber = Integer.MAX_VALUE;

        for (Integer number : numbers) {
            if (number == elementToCheck) {
                isElementPresent = true;
                break;
            } else if (number < minNumber) {
                minNumber = number;
            }
        }

        System.out.println(numbers.isEmpty() ? 0 : isElementPresent ? "true" : minNumber);
    }
}