package E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E09ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberRange = Integer.parseInt(scanner.nextLine());

        int[] numbersToTest = IntStream.rangeClosed(1, numberRange).toArray();

        int[] numberSequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Predicate<Integer> divide = n -> {
            for (int num : numberSequence) {
                if (n % num != 0) {
                    return false;
                }
            }
            return true;
        };

        System.out.println(Arrays.stream(numbersToTest)
                .filter(divide::test)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}