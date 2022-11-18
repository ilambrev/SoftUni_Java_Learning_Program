package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;

public class StateImpl implements State {

    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        this.exhibits = new ArrayList<>();
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
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

}