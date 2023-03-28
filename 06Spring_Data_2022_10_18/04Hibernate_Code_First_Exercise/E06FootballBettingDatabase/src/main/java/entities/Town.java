package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(targetEntity = Team.class, mappedBy = "town")
    private Set<Team> teams;

    public Town() {
        super();
    }

}