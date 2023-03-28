package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Prediction prediction;

    @OneToMany(targetEntity = BetGame.class, mappedBy = "resultPrediction")
    private Set<BetGame> betGames;

    public ResultPrediction() {

    }

}