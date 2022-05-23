package E01StacksAndQueues;

import java.util.Scanner;

public class E06RecursiveFibonacci {
    static long[] numbers;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fibonacciNumber = Integer.parseInt(scanner.nextLine());
        numbers = new long[fibonacciNumber + 1];
        System.out.println(getFibonacci(fibonacciNumber));
    }

    public static long getFibonacci(int n) {
        if (n < 2) {
            return 1L;
        } else if (numbers[n] == 0) {
            numbers[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        }
        return numbers[n];
    }

}