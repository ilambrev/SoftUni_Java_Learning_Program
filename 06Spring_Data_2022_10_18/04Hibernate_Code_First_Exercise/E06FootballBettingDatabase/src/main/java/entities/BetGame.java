package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bet_games")
public class BetGame implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Id
    @OneToOne
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    private Bet bet;

    @ManyToOne
    @JoinColumn(name = "result_prediction", referencedColumnName = "id")
    private ResultPrediction resultPrediction;

    public BetGame() {

    }

}