package FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> ties = new ArrayList<>();

        Map<String, String> personsData = new HashMap<>();

        Map<String, Person> persons = new LinkedHashMap<>();

        String personToFind = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            if (input.contains("-")) {
                ties.add(input);
            } else {
                String[] personData = input.split("\\s+");
                String personName = personData[0] + " " + personData[1];
                String personBirthDate = personData[2];
                personsData.put(personName, personBirthDate);
            }
            input = scanner.nextLine();
        }

        String name = null;
        String birthDate = null;

        if (personToFind.contains("/")) {
            birthDate = personToFind;
        } else {
            name = personToFind;
        }

        Person personToSearch;

        if (name != null) {
            String personBirthDate = personsData.get(name);
            personToSearch = new Person(name, personBirthDate);
        } else {
            String birthDateToFind = birthDate;
            name = personsData.entrySet().stream()
                    .filter(e -> e.getValue().equals(birthDateToFind))
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElse("");
            personToSearch = new Person(name, birthDate);
        }

        persons.put(name, personToSearch);

        for (String tie : ties) {
            String[] familyTie = tie.split(" - ");
            String parentSide = familyTie[0];
            String childSide = familyTie[1];
            String parentName;
            String parentBirthDate;
            String childName;
            String childBirthDate;

            if (parentSide.contains("/")) {
                parentName = personsData.entrySet().stream()
                        .filter(e -> e.getValue().equals(parentSide))
                        .findFirst()
                        .map(Map.Entry::getKey)
                        .orElse("");
                parentBirthDate = parentSide;
            } else {
                parentName = parentSide;
                parentBirthDate = personsData.get(parentName);
            }
            if (childSide.contains("/")) {
                childName = personsData.entrySet().stream()
                        .filter(e -> e.getValue().equals(childSide))
                        .findFirst()
                        .map(Map.Entry::getKey)
                        .orElse("");
                childBirthDate = childSide;
            } else {
                childName = childSide;
                childBirthDate = personsData.get(childName);
            }

            Person parent = new Person(parentName, parentBirthDate);
            Person child = new Person(childName, childBirthDate);
            persons.putIfAbsent(parentName, parent);
            persons.putIfAbsent(childName, child);

            persons.get(parentName).getChildren().add(persons.get(childName));
            persons.get(childName).getParents().add(persons.get(parentName));

        }

        System.out.println(personToSearch);
        System.out.println("Parents:");
        if (!personToSearch.getParents().isEmpty()) {
            personToSearch.getParents().forEach(p -> System.out.println(p.toString()));
        }
        System.out.println("Children:");
        if (!personToSearch.getChildren().isEmpty()) {
            personToSearch.getChildren().forEach(c -> System.out.println(c.toString()));
        }


    }
}