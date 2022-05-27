package E03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        String[] setsLengths = scanner.nextLine().split("\\s+");

        int firstSetLength = Integer.parseInt(setsLengths[0]);
        int secondSetLength = Integer.parseInt(setsLengths[1]);

        for (int i = 1; i <= firstSetLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 1; i <= secondSetLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        for (Integer number : firstSet) {
            if (secondSet.contains(number)) {
                System.out.print(number + " ");
            }
        }

    }
}