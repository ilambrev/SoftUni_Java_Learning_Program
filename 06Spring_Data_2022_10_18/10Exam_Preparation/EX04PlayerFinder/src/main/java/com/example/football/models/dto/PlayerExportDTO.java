package com.example.football.models.dto;

import com.example.football.constants.Positions;

public class PlayerExportDTO {

    private String firstName;

    private String lastName;

    private Positions position;

    private String teamName;

    private String teamStadiumName;

    public PlayerExportDTO() {

    }

    public PlayerExportDTO(String firstName, String lastName, Positions position, String teamName, String teamStadiumName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.teamName = teamName;
        this.teamStadiumName = teamStadiumName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamStadiumName() {
        return teamStadiumName;
    }

    public void setTeamStadiumName(String teamStadiumName) {
        this.teamStadiumName = teamStadiumName;
    }

    @Override
    public String toString() {
        return (String.format("Player - %s %s", this.firstName, this.lastName) + System.lineSeparator() +
                String.format("\tPosition - %s", this.position) + System.lineSeparator() +
                String.format("\tTeam - %s", this.teamName) + System.lineSeparator() +
                String.format("\tStadium - %s", this.teamStadiumName) + System.lineSeparator()).trim();
    }

}