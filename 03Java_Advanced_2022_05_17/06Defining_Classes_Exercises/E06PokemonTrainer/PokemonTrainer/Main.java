package PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] trainerData = input.split("\\s+");
            String trainerName = trainerData[0];
            String pokemonName = trainerData[1];
            String pokemonElement = trainerData[2];
            int pokemonHealth = Integer.parseInt(trainerData[3]);
            Trainer trainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, trainer);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.get(trainerName).getPokemon().put(pokemonName, pokemon);

            input = scanner.nextLine();
        }

        String element = scanner.nextLine();

        while (!element.equals("End")) {
            final String elementToSearch = element;
            trainers.values().forEach(t -> {
                if (!t.containsElement(elementToSearch)) {
                    t.reduceHealth(10);
                }
            });

            element = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Trainer::getBadges).reversed()))
                .forEach(e -> System.out.println(e.getValue().toString()));

    }
}