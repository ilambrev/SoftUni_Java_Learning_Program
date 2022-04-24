package E06ObjectsAndClasses;

import java.util.Arrays;
import java.util.Scanner;

public class E03OpinionPoll {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return this.name;
        }

        int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.age);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        Person[] persons = new Person[numberOfInputs];

        for (int i = 0; i < numberOfInputs; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            persons[i] = person;
        }

        Arrays.sort(persons, (p1, p2) -> (p1.getName().compareTo(p2.getName())));

        System.out.println();

        for (Person p : persons) {
            if (p.getAge() > 30) {
                System.out.println(p);
            }
        }
    }
}