package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.BaseBeverage;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalEarnedMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food;

        if ("Salad".equals(type)) {
            food = new Salad(name, price);
        } else if ("VeganBiscuits".equals(type)) {
            food = new VeganBiscuits(name, price);
        } else {
            return "";
        }

        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format("%s is already in the healthy menu!", name));
        } else {
            healthFoodRepository.add(food);
        }

        return String.format("Added %s to the healthy menu!", name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage;

        if ("Fresh".equals(type)) {
            beverage = new Fresh(name, counter, brand);
        } else if ("Smoothie".equals(type)) {
            beverage = new Smoothie(name, counter, brand);
        } else {
            return "";
        }

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format("%s is already in the beverage menu!", name));
        } else {
            beverageRepository.add(beverage);
        }

        return String.format("Added %s - %s to the beverage menu!", type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table;

        if ("Indoors".equals(type)) {
            table = new Indoors(tableNumber, capacity);
        } else if ("InGarden".equals(type)) {
            table = new InGarden(tableNumber, capacity);
        } else {
            return "";
        }

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format("Table %d is already added to the healthy restaurant!", tableNumber));
        } else {
            tableRepository.add(table);
        }

        return String.format("Added table number %d in the healthy restaurant!", tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = tableRepository.getAllEntities().stream()
                .filter(t -> t.getSize() >= numberOfPeople && !t.isReservedTable())
                .findFirst().orElse(null);

        if (table == null) {
            return String.format("There is no such table for %d people.", numberOfPeople);
        }

        table.reserve(numberOfPeople);

        return String.format("Table %d has been reserved for %s people.", table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format("Could not find table %d.", tableNumber);
        }

        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (food == null) {
            return String.format("No %s in the healthy menu.", healthyFoodName);
        }

        table.orderHealthy(food);

        return String.format("%s ordered from table %d.", healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format("Could not find table %d.", tableNumber);
        }

        Beverages beverage = beverageRepository.beverageByName(name, brand);

        if (beverage == null) {
            return String.format("No %s - %s in the beverage menu.", name, brand);
        }

        table.orderBeverages(beverage);

        return String.format("%s ordered from table %d.", name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);

        double tableBill = table.bill();

        totalEarnedMoney += tableBill;

        table.clear();

        return String.format("Table: %d with bill: %.2f", tableNumber, tableBill);
    }


    @Override
    public String totalMoney() {
        return String.format("Total money for the restaurant: %.2flv.", totalEarnedMoney);
    }

}