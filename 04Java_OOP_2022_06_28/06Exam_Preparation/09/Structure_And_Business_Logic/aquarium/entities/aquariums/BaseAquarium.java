package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Aquarium name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() < this.capacity) {
            this.fish.add(fish);
        } else {
            throw new IllegalStateException("Not enough capacity.");
        }
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : fish) {
            fish.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();

        info.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());

        if (this.fish.isEmpty()) {
            info.append("Fish: none");
        } else {
            String fishInfo = this.fish.stream().map(Fish::getName).collect(Collectors.joining(" "));
            info.append("Fish: ").append(fishInfo).append(System.lineSeparator());
        }

        info.append(String.format("Decorations: %d", decorations.size())).append(System.lineSeparator());

        info.append(String.format("Comfort: %d", calculateComfort()));

        return info.toString().trim();
    }

}