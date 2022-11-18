package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StateRepository implements Repository<State> {

    private Collection<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(this.states);
    }

    @Override
    public void add(State state) {
        this.states.add(state);
    }

    @Override
    public boolean remove(State state) {
        for (State s : this.states) {
            if (s.getName().equals(state.getName())) {
                this.states.remove(s);
                return true;
            }
        }

        return false;
    }

    @Override
    public State byName(String name) {
        return this.states.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

}