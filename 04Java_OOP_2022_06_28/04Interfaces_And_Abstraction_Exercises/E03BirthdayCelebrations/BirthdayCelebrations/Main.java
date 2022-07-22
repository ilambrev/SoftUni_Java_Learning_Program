package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] creatureDetails = input.split("\\s+");
            String type = creatureDetails[0];

            if (type.equals("Citizen")) {
                Birthable citizen = new Citizen(creatureDetails[1], Integer.parseInt(creatureDetails[2]), creatureDetails[3], creatureDetails[4]);
                birthables.add(citizen);
            } else if (type.equals("Pet")) {
                Birthable pet = new Pet(creatureDetails[1], creatureDetails[2]);
                birthables.add(pet);
            }

            input = scanner.nextLine();
        }

        String specificYear = scanner.nextLine();

        birthables.stream()
                .map(Birthable::getBirthDate)
                .filter(b -> b.endsWith(specificYear))
                .forEach(System.out::println);

    }
}