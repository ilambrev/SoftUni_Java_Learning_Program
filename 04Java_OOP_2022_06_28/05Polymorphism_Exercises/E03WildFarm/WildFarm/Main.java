package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] animalInfo = input.split("\\s+");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            Double animalWeight = Double.parseDouble(animalInfo[2]);
            String animalLivingRegion = animalInfo[3];

            switch (animalType) {
                case "Cat":
                    String catBread = animalInfo[4];
                    Animal cat = new Cat(animalName, animalWeight, animalLivingRegion, catBread);
                    animals.add(cat);
                    break;
                case "Tiger":
                    Animal tiger = new Tiger(animalName, animalWeight, animalLivingRegion);
                    animals.add(tiger);
                    break;
                case "Zebra":
                    Animal zebra = new Zebra(animalName, animalWeight, animalLivingRegion);
                    animals.add(zebra);
                    break;
                case "Mouse":
                    Animal mouse = new Mouse(animalName, animalWeight, animalLivingRegion);
                    animals.add(mouse);
                    break;
            }

            String[] foodInfo = scanner.nextLine().split("\\s+");
            String foodType = foodInfo[0];
            int foodQuantity = Integer.parseInt(foodInfo[1]);

            switch (foodType) {
                case "Vegetable":
                    Food vegetable = new Vegetable(foodQuantity);
                    foods.add(vegetable);
                    break;
                case "Meat":
                    Food meat = new Meat(foodQuantity);
                    foods.add(meat);
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            Food food = foods.get(i);

            animal.makeSound();
            animal.eat(food);
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }
}