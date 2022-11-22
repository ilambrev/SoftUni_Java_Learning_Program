package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Astronaut name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException("Cannot create Astronaut with negative oxygen!");
        } else {
            this.oxygen = oxygen;
        }
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        if (this.oxygen - 10 < 0) {
            this.oxygen = 0;
        } else {
            this.oxygen -= 10;
        }
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

}