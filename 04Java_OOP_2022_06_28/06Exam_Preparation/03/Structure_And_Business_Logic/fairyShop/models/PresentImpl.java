package fairyShop.models;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        setName(name);
        setEnergyRequired(energyRequired);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Present name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    private void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException("Cannot create a Present requiring negative energy!");
        } else {
            this.energyRequired = energyRequired;
        }
    }

    @Override
    public boolean isDone() {
        return this.energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        if (this.energyRequired - 10 < 0) {
            this.energyRequired = 0;
        } else {
            this.energyRequired -= 10;
        }
    }

}