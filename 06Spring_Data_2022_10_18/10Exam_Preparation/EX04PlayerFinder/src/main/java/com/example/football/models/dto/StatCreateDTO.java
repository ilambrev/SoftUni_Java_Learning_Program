package com.example.football.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatCreateDTO {

    @XmlElement(name = "passing")
    @NotNull
    @Positive
    private float passing;

    @XmlElement(name = "shooting")
    @NotNull
    @Positive
    private float shooting;

    @XmlElement(name = "endurance")
    @NotNull
    @Positive
    private float endurance;

    public StatCreateDTO() {

    }

    public StatCreateDTO(float passing, float shooting, float endurance) {
        this.passing = passing;
        this.shooting = shooting;
        this.endurance = endurance;
    }

    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }

}