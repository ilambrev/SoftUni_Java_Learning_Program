package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }

        return false;
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }

        return null;
    }

    public String report() {
        return String.format("%s bag contains:%n", this.color) +
                this.data.stream().map(Present::toString).collect(Collectors.joining(System.lineSeparator()));
    }

}