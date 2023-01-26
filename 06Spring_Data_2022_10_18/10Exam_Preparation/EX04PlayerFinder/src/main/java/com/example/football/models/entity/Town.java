package com.example.football.models.entity;

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

    @OneToMany(targetEntity = Team.class, mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Team> teams;

    @OneToMany(targetEntity = Player.class, mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Player> players;

    public Town() {
        super();

        this.teams = new HashSet<>();
        this.players = new HashSet<>();
    }

    public Town(String name, int population, String travelGuide, Set<Team> teams, Set<Player> players) {
        this();

        this.name = name;
        this.population = population;
        this.travelGuide = travelGuide;
        this.teams = teams;
        this.players = players;
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

}