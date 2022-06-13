package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] personData = input.split("\\s+");
            String personName = personData[0];
            String dataType = personData[1];
            Person person = new Person(personName);
            persons.putIfAbsent(personName, person);

            switch (dataType) {
                case "company":
                    String companyName = personData[2];
                    String department = personData[3];
                    double salary = Double.parseDouble(personData[4]);
                    Company company = new Company(companyName, department, salary);
                    persons.get(personName).setCompany(company);
                    break;
                case "car":
                    String carModel = personData[2];
                    int speed = Integer.parseInt(personData[3]);
                    Car car = new Car(carModel, speed);
                    persons.get(personName).setCar(car);
                    break;
                case "pokemon":
                    String pokemonName = personData[2];
                    String type = personData[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    persons.get(personName).getPokemon().add(pokemon);
                    break;
                case "parents":
                    String parentName = personData[2];
                    String parentBirthDay = personData[3];
                    Parent parent = new Parent(parentName, parentBirthDay);
                    persons.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = personData[2];
                    String childBirthDay = personData[3];
                    Child child = new Child(childName, childBirthDay);
                    persons.get(personName).getChildren().add(child);
                    break;
            }

            input = scanner.nextLine();
        }

        String personName = scanner.nextLine();

        if (persons.containsKey(personName)) {
            Person person = persons.get(personName);
            System.out.println(personName);
            System.out.println("Company:");
            if (person.getCompany().getName() != null) {
                System.out.println(person.getCompany().toString());
            }
            System.out.println("Car:");
            if (person.getCar().getModel() != null) {
                System.out.println(person.getCar().toString());
            }
            System.out.println("Pokemon:");
            if (!person.getPokemon().isEmpty()) {
                person.getPokemon().forEach(System.out::println);
            }
            System.out.println("Parents:");
            if (!person.getParents().isEmpty()) {
                person.getParents().forEach(System.out::println);
            }
            System.out.println("Children:");
            if (!person.getChildren().isEmpty()) {
                person.getChildren().forEach(System.out::println);
            }
        }

    }
}