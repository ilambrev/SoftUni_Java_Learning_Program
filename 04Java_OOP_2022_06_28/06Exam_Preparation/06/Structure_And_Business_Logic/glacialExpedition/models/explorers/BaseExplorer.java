package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Explorer name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException("Cannot create Explorer with negative energy.");
        } else {
            this.energy = energy;
        }
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public void search() {
        if (this.energy - 15 < 0) {
            this.energy = 0;
        } else {
         this.energy -= 15;
        }
    }

}