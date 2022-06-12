package PokemonTrainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private Map<String, Pokemon> pokemon;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemon = new HashMap<>();
    }

    public int getBadges() {
        return this.badges;
    }

    public Map<String, Pokemon> getPokemon() {
        return this.pokemon;
    }

    public boolean containsElement(String element) {
        long number = this.pokemon.entrySet().stream()
                .filter(entry -> entry.getValue().getElement().equals(element))
                .count();
        if (number > 0) {
            this.badges++;
        }
        return number > 0;
    }

    public void reduceHealth(int points) {
        for (var entry : pokemon.entrySet()) {
            int health = entry.getValue().getHealth() - 10;
            entry.getValue().setHealth(health);
        }
        List<String> deadPokemon = pokemon.entrySet().stream()
                .filter(e -> e.getValue().getHealth() <= 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        deadPokemon.forEach(p -> pokemon.remove(p));
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemon.size());
    }

}