package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPersons = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 1; i <= numberOfPersons; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            persons.add(person);
        }

        Predicate<Integer> age = a -> a > 30;

        persons.stream().filter(person -> age.test(person.getAge())).sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));

    }
}