package aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.fishInPool.size() < capacity && findFish(fish.getName()) == null) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }

        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }

        return null;
    }

    public String report() {
        return String.format("Aquarium: %s ^ Size: %d", this.name, this.size) + System.lineSeparator() +
                this.fishInPool.stream().map(Fish::toString).collect(Collectors.joining(System.lineSeparator()));
    }

}