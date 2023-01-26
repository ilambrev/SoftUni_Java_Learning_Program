package com.example.football.models.dto;

import com.example.football.constants.Positions;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerCreateDTO {

    @XmlElement(name = "first-name")
    @NotNull
    @Size(min = 3)
    private String firstName;

    @XmlElement(name = "last-name")
    @NotNull
    @Size(min = 3)
    private String lastName;

    @XmlElement(name = "email")
    @NotNull
    @Pattern(regexp = "^(.+)@(.+)\\.(.+)$")
    private String email;

    @XmlElement(name = "birth-date")
    @NotNull
    private String birthDate;

    @XmlElement(name = "position")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Positions position;

    @XmlElement(name = "town")
    @NotNull
    private TownSimpleDTO town;

    @XmlElement(name = "team")
    @NotNull
    private TeamSimpleDTO team;

    @XmlElement(name = "stat")
    @NotNull
    private StatSimpleDTO stat;

    public PlayerCreateDTO() {

    }

    public PlayerCreateDTO(String firstName, String lastName, String email, String birthDate,
                           Positions position, TownSimpleDTO town, TeamSimpleDTO team, StatSimpleDTO stat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.position = position;
        this.town = town;
        this.team = team;
        this.stat = stat;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public TownSimpleDTO getTown() {
        return town;
    }

    public void setTown(TownSimpleDTO town) {
        this.town = town;
    }

    public TeamSimpleDTO getTeam() {
        return team;
    }

    public void setTeam(TeamSimpleDTO team) {
        this.team = team;
    }

    public StatSimpleDTO getStat() {
        return stat;
    }

    public void setStat(StatSimpleDTO stat) {
        this.stat = stat;
    }

}