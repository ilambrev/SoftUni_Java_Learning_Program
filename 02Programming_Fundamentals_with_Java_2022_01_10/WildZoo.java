package Tests;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WildZoo {

    static class Animal {
        String name;
        int foodLimit;
        String area;

        public Animal(String name, int foodLimit, String area) {
            this.name = name;
            this.foodLimit = foodLimit;
            this.area = area;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFoodLimit() {
            return this.foodLimit;
        }

        public void setFoodLimit(int foodLimit) {
            this.foodLimit = foodLimit;
        }

        public String getArea() {
            return this.area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputCommand = scanner.nextLine();

        Map<String, Animal> animals = new LinkedHashMap<>();

        while (!inputCommand.equals("EndDay")) {
            String[] commandAndParameters = inputCommand.split(": ");
            String[] parameters = commandAndParameters[1].split("-");
            String commandName = commandAndParameters[0];
            String animalName = parameters[0];
            int foodQuantity = Integer.parseInt(parameters[1]);

            switch (commandName) {
                case "Add":
                    String area = parameters[2];
                    addAnimal(animals, animalName, foodQuantity, area);
                    break;
                case "Feed":
                    feedAnimal(animals, animalName, foodQuantity);
                    break;
            }


            inputCommand = scanner.nextLine();
        }

        Map<String, Integer> areas = new LinkedHashMap<>();

        System.out.println("Animals:");
        for (Map.Entry<String, Animal> entry : animals.entrySet()) {
            System.out.println(" " + entry.getKey() + " -> " + entry.getValue().getFoodLimit() + "g");
            String areaName = entry.getValue().getArea();
            if (areas.containsKey(areaName)) {
                areas.put(areaName, areas.get(areaName) + 1);
            } else {
                areas.put(areaName, 1);
            }
        }
        System.out.println("Areas with hungry animals:");
        for (Map.Entry<String, Integer> entry : areas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    private static void addAnimal(Map<String, Animal> animals, String animalName, int foodQuantity, String area) {
        if (animals.containsKey(animalName)) {
            int newFoodQuantity = animals.get(animalName).getFoodLimit() + foodQuantity;
            animals.get(animalName).setFoodLimit(newFoodQuantity);
        } else {
            Animal animal = new Animal(animalName, foodQuantity, area);
            animals.put(animalName, animal);
        }
    }

    private static void feedAnimal(Map<String, Animal> animals, String animalName, int foodQuantity) {
        if (animals.containsKey(animalName)) {
            int newFoodQuantity = animals.get(animalName).getFoodLimit() - foodQuantity;
            if (newFoodQuantity <= 0) {
                System.out.println(animalName + " was successfully fed");
                animals.remove(animalName);
            } else {
                animals.get(animalName).setFoodLimit(newFoodQuantity);
            }
        }
    }

}