package E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08CustomComparator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Comparator<Integer> comparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            } else if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            } else {
                return n1.compareTo(n2);
            }
        };

        System.out.println(numbers.stream().sorted(comparator).map(String::valueOf).collect(Collectors.joining(" ")));

    }
}