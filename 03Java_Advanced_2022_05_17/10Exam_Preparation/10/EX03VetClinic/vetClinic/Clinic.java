package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet p : this.data) {
            if (p.getName().equals(name)) {
                data.remove(p);
                return true;
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                return p;
            }
        }

        return null;
    }

    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparingInt(Pet::getAge))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return "The clinic has the following patients:" + System.lineSeparator() +
                this.data.stream().map(p -> String.format("%s %s", p.getName(), p.getOwner()))
                        .collect(Collectors.joining(System.lineSeparator()));
    }

}