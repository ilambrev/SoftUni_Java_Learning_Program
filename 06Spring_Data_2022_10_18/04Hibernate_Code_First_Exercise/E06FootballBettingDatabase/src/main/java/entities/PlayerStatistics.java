package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistics implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @Column(name = "scored_goals")
    private int scoredGoals;

    @Column(name = "player_assists")
    private int playerAssists;

    @Column(name = "played_minutes")
    private int playedMinutesDuringGame;

    public PlayerStatistics() {

    }

}
