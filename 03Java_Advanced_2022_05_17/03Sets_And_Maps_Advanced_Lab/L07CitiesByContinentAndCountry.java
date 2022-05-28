package L03SetsAndMapsAdvanced;

import java.util.*;

public class L07CitiesByContinentAndCountry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        int numberOfInputLines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfInputLines; i++) {
            String[] continentData = scanner.nextLine().split("\\s+");
            String continent = continentData[0];
            String country = continentData[1];
            String city = continentData[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }

        for (var continent : continents.entrySet()) {
            System.out.println(continent.getKey() + ":");
            continent.getValue().forEach((key, value) -> System.out.printf("  %s -> %s%n", key, String.join(", ", value)));
        }

    }
}