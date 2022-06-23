package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot p : this.data) {
            if (p.getName().equals(name)) {
                data.remove(p);
                return true;
            }
        }

        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = null;
        for (Parrot p : this.data) {
            if (p.getName().equals(name)) {
                parrot = p;
                p.setAvailable(false);
                break;
            }
        }

        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot p : this.data) {
            if (p.getSpecies().equals(species)) {
                soldParrots.add(p);
                sellParrot(p.getName());
            }
        }

        return soldParrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        String parrots = this.data.stream().filter(Parrot::isAvailable)
                .map(Parrot::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        return String.format("Parrots available at %s:%n%s", this.name, parrots);
    }

}