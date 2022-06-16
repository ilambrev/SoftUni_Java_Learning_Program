package GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box<T> {
    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T input) {
        data.add(input);
    }

    @Override
    public String toString() {
        return data.stream().map(e -> String.format("%s: %s", e.getClass().getName(), e))
                .collect(Collectors.joining(System.lineSeparator()));
    }

}