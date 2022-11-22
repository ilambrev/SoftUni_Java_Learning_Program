package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetImpl implements Planet {

    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        setName(name);
        this.items = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Invalid name!");
        } else {
            this.name = name;
        }
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

}