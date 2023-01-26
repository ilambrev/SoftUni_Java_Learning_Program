package com.example.football.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownCreateDTO {

    @Expose
    @NotNull
    @Size(min = 2)
    private String name;

    @Expose
    @NotNull
    @Positive
    private int population;

    @Expose
    @NotNull
    @Size(min = 10)
    private String travelGuide;

    public TownCreateDTO() {

    }

    public TownCreateDTO(String name, int population, String travelGuide) {
        this.name = name;
        this.population = population;
        this.travelGuide = travelGuide;
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

}