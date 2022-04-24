package E06ObjectsAndClasses;

import java.util.*;

public class E07OrderByAge {

    static class Person {
        String name;
        String id;
        int age;

        Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }
        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        List<Person> persons = new ArrayList<>();

        while (!inputString.equals("End")) {
            String[] input = inputString.split("\\s+");
            Person person = new Person(input[0], input[1], Integer.parseInt(input[2]));
            persons.add(person);
            inputString = scanner.nextLine();
        }

        persons.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        for (Person p : persons) {
            System.out.println(p);
        }
    }
}