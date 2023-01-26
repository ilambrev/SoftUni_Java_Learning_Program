package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayersDTO {

    @XmlElement(name = "player")
    private List<PlayerCreateDTO> players;

    public PlayersDTO() {
        this.players = new ArrayList<>();
    }

    public PlayersDTO(List<PlayerCreateDTO> players) {
        this.players = players;
    }

    public List<PlayerCreateDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerCreateDTO> players) {
        this.players = players;
    }

}