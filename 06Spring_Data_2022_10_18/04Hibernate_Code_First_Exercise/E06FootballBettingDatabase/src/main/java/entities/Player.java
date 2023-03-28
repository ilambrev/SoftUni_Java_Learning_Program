package entities;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "squad_number", nullable = false)
    private int squadNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @Column(name = "is_injured")
    private boolean isCurrentlyInjured;

    public Player() {
        super();
    }

}