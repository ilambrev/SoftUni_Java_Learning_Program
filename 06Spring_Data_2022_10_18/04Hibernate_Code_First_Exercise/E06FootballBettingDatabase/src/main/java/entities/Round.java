package entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "rounds")
public class Round extends BaseEntity {

    @OneToMany(targetEntity = Game.class, mappedBy = "round")
    private Set<Game> games;

    public Round() {
        super();
    }

}