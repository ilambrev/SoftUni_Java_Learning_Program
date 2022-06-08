package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L06FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] bound = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lowerBound = bound[0];
        int upperBound = bound[1];

        String command = scanner.nextLine();

        Predicate<Integer> oddOrEven = num -> {
            if (command.equals("odd")) {
                return num % 2 != 0;
            } else {
                return num % 2 == 0;
            }
        };

        System.out.println(IntStream.range(lowerBound, upperBound + 1).filter(oddOrEven::test)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}