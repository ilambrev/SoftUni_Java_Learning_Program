package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                this.roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : this.roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }

        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        String hotel = String.format("The people in the hotel %s are:%n", this.name);
        String people = this.roster.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
        return hotel + people;
    }

}