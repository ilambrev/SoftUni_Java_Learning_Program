package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemon;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.car = new Car();
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, Company company) {
        this(name);
        this.company = company;
    }

    public Person(String name, Car car) {
        this(name);
        this.car = car;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemon() {
        return this.pokemon;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

}