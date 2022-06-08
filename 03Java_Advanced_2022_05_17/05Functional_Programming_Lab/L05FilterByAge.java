package L05FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class L05FilterByAge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPairs = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfPairs; i++) {
            String[] pair = scanner.nextLine().split(",\\s+");
            String name = pair[0];
            int age = Integer.parseInt(pair[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split("\\s+");

        Predicate<Integer> ageLimit = a -> {
            if (condition.equals("younger")) {
                return a <= age;
            } else {
                return a >= age;
            }
        };

        Consumer<Map.Entry<String, Integer>> print = person -> {
            if (format.length == 2) {
                System.out.println(person.getKey() + " - " + person.getValue());
            } else {
                System.out.println(format[0].equals("name") ? person.getKey() : person.getValue());
            }
        };

        people.entrySet().stream().filter(entry -> ageLimit.test(entry.getValue()))
                .forEach(print);

    }
}