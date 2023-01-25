package exam.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "population", nullable = false)
    private int population;

    @Column(name = "travel_guide", nullable = false, columnDefinition = "Text")
    private String travelGuide;

    @OneToMany(targetEntity = Shop.class, mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Shop> shops;

    @OneToMany(targetEntity = Customer.class, mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Customer> customers;

    public Town() {
        super();

        this.shops = new HashSet<>();
        this.customers = new HashSet<>();
    }

    public Town(String name, int population, String travelGuide, Set<Shop> shops, Set<Customer> customers) {
        this();

        this.name = name;
        this.population = population;
        this.travelGuide = travelGuide;
        this.shops = shops;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

}