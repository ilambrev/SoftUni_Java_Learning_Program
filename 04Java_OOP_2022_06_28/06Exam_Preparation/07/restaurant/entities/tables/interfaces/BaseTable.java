package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        setSize(size);
        this.numberOfPeople = 0;
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.allPeople = 0.0;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size has to be greater than 0!");
        } else {
            this.size = size;
        }
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException("Cannot place zero or less people!");
        } else {
            this.numberOfPeople = numberOfPeople;
        }
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.allPeople = this.numberOfPeople * this.pricePerPerson;
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double billForHealthyFood = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double billForBeverages = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();

        return billForHealthyFood + billForBeverages + allPeople;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.numberOfPeople = 0;
        this.isReservedTable = false;
        this.allPeople = 0.0;
    }

    @Override
    public String tableInformation() {
        StringBuilder tableInfo = new StringBuilder();

        tableInfo.append(String.format("Table - %d", this.number)).append(System.lineSeparator());

        tableInfo.append(String.format("Size - %d", this.size)).append(System.lineSeparator());

        tableInfo.append(String.format("Type - %s", getClass().getSimpleName())).append(System.lineSeparator());

        tableInfo.append(String.format("All price - %.2f", this.pricePerPerson)).append(System.lineSeparator());

        return tableInfo.toString().trim();
    }

}