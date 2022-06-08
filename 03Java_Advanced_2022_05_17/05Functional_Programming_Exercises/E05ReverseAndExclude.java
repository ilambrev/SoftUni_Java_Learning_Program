package E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisor = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        System.out.println(numbers.stream().filter(num -> num % divisor != 0)
                .map(String::valueOf).collect(Collectors.joining(" ")));

    }
}