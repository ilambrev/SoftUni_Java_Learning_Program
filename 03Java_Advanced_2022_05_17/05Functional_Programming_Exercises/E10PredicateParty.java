package E05FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            String condition = commandParts[1];
            String criteria = commandParts[2];
            switch (command) {
                case "Remove":
                    people = removePersons(people, condition, criteria);
                    break;
                case "Double":
                    doublePersons(people, condition, criteria);
                    break;
            }

            input = scanner.nextLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(people.stream().sorted().collect(Collectors.joining(", ")));
            System.out.println(" are going to the party!");
        }


    }

    private static List<String> removePersons(List<String> people, String condition, String criteria) {
        List<String> temp = new ArrayList<>();
        switch (condition) {
            case "StartsWith":

                Predicate<String> startString = p -> {
                    if (p.length() >= criteria.length()) {
                        return !p.substring(0, criteria.length()).equals(criteria);
                    } else {
                        return true;
                    }
                };

                temp = people.stream().filter(startString).collect(Collectors.toList());
                break;
            case "EndsWith":

                Predicate<String> endString = p -> {
                    if (p.length() >= criteria.length()) {
                        return !p.substring(p.length() - criteria.length()).equals(criteria);
                    } else {
                        return true;
                    }
                };

                temp = people.stream().filter(endString).collect(Collectors.toList());
                break;
            case "Length":
                int length = Integer.parseInt(criteria);

                Predicate<String> stringLength = p -> {
                    if (p.length() >= criteria.length()) {
                        return p.length() != length;
                    } else {
                        return true;
                    }
                };

                temp = people.stream().filter(stringLength).collect(Collectors.toList());
                break;

        }
        return temp;
    }

    private static List<String> doublePersons(List<String> people, String condition, String criteria) {
        List<String> temp = new ArrayList<>();
        switch (condition) {
            case "StartsWith":

                Predicate<String> startString = p -> {
                    if (p.length() >= criteria.length()) {
                        return p.substring(0, criteria.length()).equals(criteria);
                    } else {
                        return false;
                    }
                };

                temp = people.stream().filter(startString).collect(Collectors.toList());
                break;
            case "EndsWith":

                Predicate<String> endString = p -> {
                    if (p.length() >= criteria.length()) {
                        return p.substring(p.length() - criteria.length()).equals(criteria);
                    } else {
                        return false;
                    }
                };

                temp = people.stream().filter(endString).collect(Collectors.toList());
                break;
            case "Length":
                int length = Integer.parseInt(criteria);

                Predicate<String> stringLength = p -> {
                    if (p.length() >= criteria.length()) {
                        return p.length() == length;
                    } else {
                        return false;
                    }
                };

                temp = people.stream().filter(stringLength).collect(Collectors.toList());
                break;

        }
        people.addAll(temp);
        return people;
    }

}