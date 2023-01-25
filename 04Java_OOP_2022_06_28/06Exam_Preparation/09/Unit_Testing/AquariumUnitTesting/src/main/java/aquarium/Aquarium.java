package aquarium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Aquarium {
    private String name;
    private int capacity;
    private Collection<Fish> fish;

    public Aquarium(String name, int capacity){
        this.setCapacity(capacity);
        this.setName(name);
        this.fish = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException("Invalid aquarium name!");
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid aquarium capacity!");
        }
        this.capacity = capacity;
    }

    public int getCount() {
        return this.fish.size();
    }

    public void add(Fish fish){
        if (this.fish.size() == this.capacity){
            throw new IllegalArgumentException("Aquarium is full!");
        }
        this.fish.add(fish);
    }

    public void remove(String name) {
        Fish fishToRemove = this.fish.stream()
                .filter(f -> name.equals(f.getName()))
                .findAny()
                .orElse(null);
        if (fishToRemove == null){
            throw new IllegalArgumentException(String.format("Fish with name %s doesn't exist", name));
        }
        this.fish.remove(fishToRemove);
    }

    public Fish sellFish(String name){
        Fish requestedFish = this.fish.stream()
                .filter(f -> name.equals(f.getName()))
                .findAny()
                .orElse(null);
        if (requestedFish == null){
            throw new IllegalArgumentException(String.format("Fish with name %s doesn't exist", name));
        }
        requestedFish.setAvailable(false);

        return requestedFish;
    }

    public String report(){
        String names = this.fish.stream().map(Fish::getName).collect(Collectors.joining(", "));
        return String.format("Fish available at %s: %s", this.name, names);
    }
}
