package E03SetsAndMapsAdvanced;

import java.util.*;

public class E09PopulationCounter {

    static class Country {
        String name;
        long population;
        Map<String, Long> cities;

        public Country(String name, int population, Map<String, Long> cities) {
            this.name = name;
            this.population = population;
            this.cities = cities;

        }

        public String getName() {
            return this.name;
        }

        public long getPopulation() {
            return this.population;
        }

        public Map<String, Long> getCities() {
            return this.cities;
        }

        public void setPopulation(long population) {
            this.population = population;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Country> countries = new LinkedHashMap<>();

        String token = scanner.nextLine();

        while (!token.equals("report")) {
            String[] pair = token.split("\\|+");
            String country = pair[1];
            String city = pair[0];
            long population = Integer.parseInt(pair[2]);

            Country newCountry = new Country(country, 0, new LinkedHashMap<>());
            countries.putIfAbsent(country, newCountry);
            countries.get(country).getCities().put(city, population);
            long newPopulation = countries.get(country).getPopulation() + population;
            countries.get(country).setPopulation(newPopulation);

            token = scanner.nextLine();
        }


        countries.values().stream().sorted(Comparator.comparing(Country::getPopulation).reversed())
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getName(), e.getPopulation());
                    e.getCities().entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .forEach(c -> System.out.printf("=>%s: %d%n", c.getKey(), c.getValue()));
                });

    }
}