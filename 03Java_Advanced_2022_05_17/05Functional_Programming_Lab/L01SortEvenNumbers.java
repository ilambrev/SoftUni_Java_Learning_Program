package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] evenNumbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).filter(d -> d % 2 == 0)
                .toArray();

        System.out.println(Arrays.stream(evenNumbers).mapToObj(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(evenNumbers).sorted().mapToObj(String::valueOf).collect(Collectors.joining(", ")));

    }
}