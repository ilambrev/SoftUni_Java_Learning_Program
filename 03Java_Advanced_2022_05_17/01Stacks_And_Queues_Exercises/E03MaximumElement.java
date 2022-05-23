package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] commandParams = scanner.nextLine().split("\\s+");
            String command = commandParams[0];
            switch (command) {
                case "1":
                    numbers.push(Integer.parseInt(commandParams[1]));
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(maxElement(numbers));
                    break;
            }
        }
    }

    public static int maxElement(ArrayDeque<Integer> numbers) {
        int maxElement = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if (number > maxElement) {
                maxElement = number;
            }
        }
        return maxElement;
    }

}