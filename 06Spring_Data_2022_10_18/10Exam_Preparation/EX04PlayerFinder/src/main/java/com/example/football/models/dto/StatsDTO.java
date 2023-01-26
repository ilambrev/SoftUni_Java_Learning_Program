package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsDTO {

    @XmlElement(name = "stat")
    private List<StatCreateDTO> stats;

    public StatsDTO() {
        this.stats = new ArrayList<>();
    }

    public StatsDTO(List<StatCreateDTO> stats) {
        this.stats = stats;
    }

    public List<StatCreateDTO> getStats() {
        return stats;
    }

    public void setStats(List<StatCreateDTO> stats) {
        this.stats = stats;
    }

}