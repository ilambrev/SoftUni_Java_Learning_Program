package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(name = "town_name", nullable = false, unique = true)
    private String townName;

    @Column(name = "population", nullable = false)
    private int population;

    @OneToMany(targetEntity = Agent.class, mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Agent> agents;

    @OneToMany(targetEntity = Apartment.class, mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Apartment> apartments;

    public Town() {
        super();

        this.agents = new HashSet<>();
        this.apartments = new HashSet<>();
    }

    public Town(String townName, int population, Set<Agent> agents, Set<Apartment> apartments) {
        this();

        this.townName = townName;
        this.population = population;
        this.agents = agents;
        this.apartments = apartments;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Set<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Set<Agent> agents) {
        this.agents = agents;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Set<Apartment> apartments) {
        this.apartments = apartments;
    }

}