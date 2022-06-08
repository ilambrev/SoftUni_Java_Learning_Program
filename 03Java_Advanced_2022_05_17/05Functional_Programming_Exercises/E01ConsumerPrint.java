package E05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E01ConsumerPrint {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        Consumer<String> string = System.out::println;

        Arrays.stream(strings).forEach(string);

    }
}