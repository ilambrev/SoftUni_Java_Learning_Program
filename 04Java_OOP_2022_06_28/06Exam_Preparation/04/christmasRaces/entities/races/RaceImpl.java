package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 5) {
            String message = String.format("Name %s cannot be less than 5 symbols.", name);
            throw new IllegalArgumentException(message);
        } else {
            this.name = name;
        }
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException("Laps cannot be less than 1.");
        } else {
            this.laps = laps;
        }
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null.");
        } else if (!driver.getCanParticipate()) {
            String message = String.format("Driver %s could not participate in race.", driver.getName());
            throw new IllegalArgumentException(message);
        } else if (this.drivers.contains(driver)) {
            String message = String.format("Driver %s is already added in %s race.", driver.getName(), this.name);
            throw new IllegalArgumentException(message);
        } else {
            this.drivers.add(driver);
        }
    }

}