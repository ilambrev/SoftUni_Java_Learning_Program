package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class L03CountUppercaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> wordStartingWithUppercase = e -> Character.isUpperCase(e.charAt(0));

        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(wordStartingWithUppercase)
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(System.out::println);

    }
}