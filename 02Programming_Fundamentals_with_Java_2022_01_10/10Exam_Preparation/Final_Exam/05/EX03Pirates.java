package EX05FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03Pirates {

    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return this.name;
        }

        public int getPopulation() {
            return this.population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return this.gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();

        Map<String, City> cities = new LinkedHashMap<>();

        while (!inputData.equals("Sail")) {
            fillCityData(cities, inputData);
            inputData = scanner.nextLine();
        }

        String inputEvents = scanner.nextLine();

        while (!inputEvents.equals("End")) {
            String[] eventParts = inputEvents.split("=>");
            String event = eventParts[0];
            String cityName = eventParts[1];
            switch (event) {
                case "Plunder":
                    cityPlunder(cities, cityName, Integer.parseInt(eventParts[2]), Integer.parseInt(eventParts[3]));
                    break;
                case "Prosper":
                    cityProsper(cities, cityName, Integer.parseInt(eventParts[2]));
                    break;
            }
            inputEvents = scanner.nextLine();
        }

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
        }
        for (City city : cities.values()) {
            System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city.getName(), city.getPopulation(), city.getGold());
        }
    }

    private static void fillCityData(Map<String, City> cities, String inputData) {
        String[] citiesInputData = inputData.split("\\|\\|");
        String cityName = citiesInputData[0];
        int population = Integer.parseInt(citiesInputData[1]);
        int gold = Integer.parseInt(citiesInputData[2]);
        if (cities.containsKey(cityName)) {
            int oldPopulationValue = cities.get(cityName).getPopulation();
            int oldGoldValue = cities.get(cityName).getGold();
            cities.get(cityName).setPopulation(oldPopulationValue + population);
            cities.get(cityName).setGold(oldGoldValue + gold);
        } else {
            City city = new City(cityName, population, gold);
            cities.put(cityName, city);
        }
    }

    private static void cityPlunder(Map<String, City> cities, String city, int killedPeople, int stolenGold) {
        int oldPopulationValue = cities.get(city).getPopulation();
        int oldGoldValue = cities.get(city).getGold();
        cities.get(city).setPopulation(oldPopulationValue - killedPeople);
        cities.get(city).setGold(oldGoldValue - stolenGold);
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, stolenGold, killedPeople);
        if (cities.get(city).getPopulation() == 0 || cities.get(city).getGold() == 0) {
            cities.remove(city);
            System.out.printf("%s has been wiped off the map!%n", city);
        }
    }

    private static void cityProsper(Map<String, City> cities, String city, int extraGold) {
        if (extraGold < 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else if (extraGold > 0) {
            int oldGoldValue = cities.get(city).getGold();
            cities.get(city).setGold(oldGoldValue + extraGold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", extraGold, city, cities.get(city).getGold());
        }
    }

}