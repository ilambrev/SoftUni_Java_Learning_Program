package E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06PredicateForNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stringLengthToCheck = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkLength = s -> s.length() <= stringLengthToCheck;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(checkLength).forEach(System.out::println);

    }
}