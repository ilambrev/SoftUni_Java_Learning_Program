package L05FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Function;

public class L02SumNumbersV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");

        Function<String, Integer> parse = Integer::parseInt;

        int sum = 0;

        for (String num : numbers) {
            sum += parse.apply(num);
        }

        System.out.printf("Count = %d%nSum = %d%n", numbers.length, sum);

    }
}