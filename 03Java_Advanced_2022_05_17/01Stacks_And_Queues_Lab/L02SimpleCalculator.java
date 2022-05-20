package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (int i = inputString.length - 1; i >= 0; i--) {
            numbers.push(inputString[i]);
        }

        int result = Integer.parseInt(numbers.pop());
        String current = null;

        for (String number : numbers) {
            if ("+".equals(number) || "-".equals(number)) {
                current = numbers.pop();
            } else {
                if ("+".equals(current)) {
                    result += Integer.parseInt(numbers.pop());
                } else {
                    result -= Integer.parseInt(numbers.pop());
                }
            }
        }
        System.out.println(result);
    }
}