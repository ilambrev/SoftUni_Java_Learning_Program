package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("House name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() < this.capacity) {
            this.cats.add(cat);
        } else {
            throw new IllegalStateException("Not enough capacity for this cat.");
        }
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : this.cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder houseInfo = new StringBuilder();
        houseInfo.append(String.format("%s %s:", this.name, getClass().getSimpleName())).append(System.lineSeparator());

        if (this.cats.isEmpty()) {
            houseInfo.append("Cats: none").append(System.lineSeparator());
        } else {
            houseInfo.append("Cats: ");
            String cats = this.cats.stream().map(Cat::getName).collect(Collectors.joining(" "));
            houseInfo.append(cats).append(System.lineSeparator());
        }

        houseInfo.append(String.format("Toys: %d", this.toys.size()));
        houseInfo.append(String.format(" Softness: %d", sumSoftness())).append(System.lineSeparator());

        return houseInfo.toString().trim();
    }

}