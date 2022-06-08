package E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E03CustomMinFunction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Function<Integer[], Integer> minValue = array -> {
            int smallestNumber = Integer.MAX_VALUE;
            for (Integer num : array) {
                if (num < smallestNumber) {
                    smallestNumber = num;
                }
            }
            return smallestNumber;
        };

        System.out.println(minValue.apply(numbers));

    }
}