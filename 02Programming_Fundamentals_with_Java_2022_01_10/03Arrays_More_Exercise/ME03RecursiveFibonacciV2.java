package ME03Arrays;

import java.util.Scanner;

public class ME03RecursiveFibonacciV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fibonacciNumber = Integer.parseInt(scanner.nextLine());
        long result = getFibonacci(fibonacciNumber);
        System.out.println(result);
    }

    public static long getFibonacci(long number) {
        if (number == 0 || number == 1) {
            return number;
        } else {
            System.out.println(number);
            return number = getFibonacci(number - 1) + getFibonacci(number - 2);
        }
    }

}