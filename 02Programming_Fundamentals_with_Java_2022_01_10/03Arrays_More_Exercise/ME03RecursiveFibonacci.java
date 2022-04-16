package ME03Arrays;

import java.util.Scanner;

public class ME03RecursiveFibonacci {

    static long[] numbers = new long[51];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fibonacciNumber = Integer.parseInt(scanner.nextLine());
        long result = getFibonacci(fibonacciNumber);
        System.out.println(result);
    }

    public static long getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (numbers[n] == 0) {
            numbers[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        }
        return numbers[n];
    }

}