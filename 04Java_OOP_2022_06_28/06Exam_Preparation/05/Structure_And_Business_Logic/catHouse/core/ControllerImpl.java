package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {

        if (!"ShortHouse".equals(type) && !"LongHouse".equals(type)) {
            throw new NullPointerException("Invalid house type.");
        }

        House house;

        if ("ShortHouse".equals(type)) {
            house = new ShortHouse(name);
        } else {
            house = new LongHouse(name);
        }

        this.houses.add(house);

        return String.format("%s is successfully added.", type);
    }

    @Override
    public String buyToy(String type) {

        if (!"Ball".equals(type) && !"Mouse".equals(type)) {
            throw new IllegalArgumentException("Invalid toy type.");
        }

        Toy toy;

        if ("Ball".equals(type)) {
            toy = new Ball();
        } else {
            toy = new Mouse();
        }

        toys.buyToy(toy);

        return String.format("%s is successfully added.", type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {

        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format("Toy of type %s is missing.", toyType));
        }

        assert house != null;
        house.buyToy(toy);

        toys.removeToy(toy);

        return String.format("Successfully added %s to %s.", toy.getClass().getSimpleName(), houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        if (!"ShorthairCat".equals(catType) && !"LonghairCat".equals(catType)) {
            throw new IllegalArgumentException("Invalid cat type.");
        }

        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        assert house != null;

        Cat cat;

        if ("ShorthairCat".equals(catType)) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else {
            cat = new LonghairCat(catName, catBreed, price);
        }

        if (("ShorthairCat".equals(catType) && "ShortHouse".equals(house.getClass().getSimpleName())) ||
                ("LonghairCat".equals(catType) && "LongHouse".equals(house.getClass().getSimpleName()))) {

            house.addCat(cat);

        } else {
            return "Unsuitable house.";
        }

        return String.format("Successfully added %s to %s.", catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {

        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        assert house != null;

        house.feeding();

        return String.format("Feeding a cat: %d", house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {

        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        assert house != null;

        double sumOfCatsPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();

        double sumOfToysPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();

        double houseValue = sumOfCatsPrice + sumOfToysPrice;

        return String.format("The value of House %s is %.2f.", houseName, houseValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder allHousesStat = new StringBuilder();

        for (House house : this.houses) {
            allHousesStat.append(house.getStatistics()).append(System.lineSeparator());
        }

        return allHousesStat.toString().trim();
    }

}