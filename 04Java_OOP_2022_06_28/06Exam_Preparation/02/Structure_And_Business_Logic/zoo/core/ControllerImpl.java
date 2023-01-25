package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        if (!"WaterArea".equals(areaType) && !"LandArea".equals(areaType)) {
            throw new NullPointerException("Invalid area type.");
        } else {

            Area area;

            if ("WaterArea".equals(areaType)) {
                area = new WaterArea(areaName);
            } else {
                area = new LandArea(areaName);
            }

            areas.add(area);

            return String.format("Successfully added %s.", areaType);
        }
    }


    @Override
    public String buyFood(String foodType) {
        if (!"Vegetable".equals(foodType) && !"Meat".equals(foodType)) {
            throw new IllegalArgumentException("Invalid food type.");
        } else {

            Food food;

            if ("Vegetable".equals(foodType)) {
                food = new Vegetable();
            } else {
                food = new Meat();
            }

            foodRepository.add(food);

            return String.format("Successfully added %s.", foodType);
        }
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            String exceptionMessage = String.format("There isn't a food of type %s.", foodType);
            throw new IllegalArgumentException(exceptionMessage);
        } else {

            Area area = areaByName(areaName);
            area.addFood(food);
            foodRepository.remove(food);

            return String.format("Successfully added %s to %s.", foodType, areaName);
        }
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        String message;

        if (!"AquaticAnimal".equals(animalType) && !"TerrestrialAnimal".equals(animalType)) {
            throw new IllegalArgumentException("Invalid animal type.");
        } else {

            Area area = areaByName(areaName);

            String areaType = area.getClass().getSimpleName();

            if (("WaterArea".equals(areaType) && "AquaticAnimal".equals(animalType)) ||
                    ("LandArea".equals(areaType) && "TerrestrialAnimal".equals(animalType))) {

                Animal animal;

                if ("AquaticAnimal".equals(animalType)) {
                    animal = new AquaticAnimal(animalName, kind, price);
                } else {
                    animal = new TerrestrialAnimal(animalName, kind, price);
                }

                try {
                    area.addAnimal(animal);
                    message = String.format("Successfully added %s to %s.", animalType, areaName);
                } catch (IllegalStateException e) {
                    message = e.getMessage();
                }

            } else {
                message = "The external living environment is not suitable.";
            }

        }

        return message;
    }

    @Override
    public String feedAnimal(String areaName) {

        Area area = areaByName(areaName);
        area.feed();

        return String.format("Animals fed: %d", area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {

        Area area = areaByName(areaName);

        double areaKG = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();

        return String.format("The kilograms of Area %s is %.2f.", areaName, areaKG);
    }

    @Override
    public String getStatistics() {
        StringBuilder areasInfo = new StringBuilder();

        for (Area area : areas) {
            areasInfo.append(area.getInfo()).append(System.lineSeparator());
        }

        return areasInfo.toString().trim();
    }

    private Area areaByName(String areaName) {
        return areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
    }

}