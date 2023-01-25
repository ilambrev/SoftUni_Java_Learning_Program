package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;


    public BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Area name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        } else {
            throw new IllegalStateException("Not enough capacity.");
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal a : animals) {
            a.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();

        info.append(String.format("%s (%s):", name, this.getClass().getSimpleName())).append(System.lineSeparator());

        if (animals.isEmpty()) {
            info.append("Animals: none").append(System.lineSeparator());
        } else {
            info.append("Animals: ");
            String animalsNames = animals.stream().map(Animal::getName).collect(Collectors.joining(" "));
            info.append(animalsNames).append(System.lineSeparator());
        }

        info.append("Foods: ").append(foods.size()).append(System.lineSeparator());

        info.append("Calories: ").append(sumCalories());

        return info.toString();
    }

}