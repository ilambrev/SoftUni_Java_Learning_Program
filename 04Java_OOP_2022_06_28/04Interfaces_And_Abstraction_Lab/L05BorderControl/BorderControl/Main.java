package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] visitorDetails = input.split("\\s+");

            Identifiable identifiable;

            if (visitorDetails.length == 2) {
                identifiable = new Robot(visitorDetails[0], visitorDetails[1]);
            } else {
                identifiable = new Citizen(visitorDetails[0], Integer.parseInt(visitorDetails[1]), visitorDetails[2]);
            }

            identifiables.add(identifiable);

            input = scanner.nextLine();
        }

        String lastDigitsOfFakeIDs = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(i -> i.endsWith(lastDigitsOfFakeIDs))
                .forEach(System.out::println);

    }
}