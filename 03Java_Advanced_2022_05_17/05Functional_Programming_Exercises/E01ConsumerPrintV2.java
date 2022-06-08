package E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class E01ConsumerPrintV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<String> string = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList()).forEach(string);

    }
}