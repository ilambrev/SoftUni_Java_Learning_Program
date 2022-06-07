package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class L02SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        System.out.printf("Count = %d%nSum = %d%n", numbers.length, Arrays.stream(numbers).sum());

    }
}