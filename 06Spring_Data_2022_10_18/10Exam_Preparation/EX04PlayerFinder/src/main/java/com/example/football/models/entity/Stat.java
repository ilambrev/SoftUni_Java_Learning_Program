package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity {

    @Column(name = "shooting", nullable = false)
    private float shooting;

    @Column(name = "passing", nullable = false)
    private float passing;

    @Column(name = "endurance", nullable = false)
    private float endurance;

    @OneToOne(targetEntity = Player.class, mappedBy = "stat", optional = false)
    private Player player;

    public Stat() {
        super();
    }

    public Stat(float shooting, float passing, float endurance, Player player) {
        this();

        this.shooting = shooting;
        this.passing = passing;
        this.endurance = endurance;
        this.player = player;
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}