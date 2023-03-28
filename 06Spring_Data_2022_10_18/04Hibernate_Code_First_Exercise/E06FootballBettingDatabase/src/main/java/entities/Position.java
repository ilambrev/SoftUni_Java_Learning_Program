package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @Column(length = 2)
    private String id;

    @Column(name = "position_description")
    private String positionDescription;

    @OneToMany(targetEntity = Player.class, mappedBy = "position")
    private Set<Player> players;

    public Position() {
    }

}