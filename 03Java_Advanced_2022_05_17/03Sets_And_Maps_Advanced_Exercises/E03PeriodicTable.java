package E03SetsAndMapsAdvanced;

import java.util.*;

public class E03PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> chemCompounds = new TreeSet<>();

        int tokens = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= tokens; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            chemCompounds.addAll(Arrays.asList(token));
        }

        for (String element : chemCompounds) {
            System.out.print(element + " ");
        }

    }
}