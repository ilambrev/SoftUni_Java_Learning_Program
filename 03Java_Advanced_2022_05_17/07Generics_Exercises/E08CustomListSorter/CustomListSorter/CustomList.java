package CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        if (index >= 0 && index < this.elements.size()) {
            T element = this.elements.get(index);
            this.elements.remove(index);
            return element;
        }

        return null;
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < this.elements.size() && index2 >= 0 && index2 < this.elements.size()) {
            Collections.swap(this.elements, index1, index2);
        }
    }

    public int countGreaterThan(T element) {
        return (int) this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.elements.stream().max(Comparable::compareTo).orElse(null);
    }

    public T getMin() {
        return this.elements.stream().min(Comparable::compareTo).orElse(null);
    }

    public int size() {
        return this.elements.size();
    }

    public T get(int index) {
        return index >= 0 && index < this.elements.size() ? this.elements.get(index) : null;
    }

    @Override
    public String toString() {
        return this.elements.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

}