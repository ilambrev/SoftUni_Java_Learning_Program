package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseEntity {

    @ManyToMany(targetEntity = Country.class, mappedBy = "continents")
    private Set<Country> countries;

    public Continent() {
        super();
    }

}