package E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E06RecursiveFibonacciV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int indexOfNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> numbers = new ArrayDeque<>();

        System.out.println(getFibonacci(numbers, indexOfNumber));

    }

    public static Long getFibonacci(ArrayDeque<Long> numbers, int indexOfNumber) {
        if (indexOfNumber < 2) {
            return 1L;
        } else {
            numbers.push(1L);
            numbers.push(1L);
            for (int i = 1; i < indexOfNumber; i++) {
                long firstNum = numbers.pop();
                long secondNum = numbers.pop();
                long number = firstNum + secondNum;
                numbers.push(firstNum);
                numbers.push(number);
            }
        }
        return numbers.peek();
    }
}