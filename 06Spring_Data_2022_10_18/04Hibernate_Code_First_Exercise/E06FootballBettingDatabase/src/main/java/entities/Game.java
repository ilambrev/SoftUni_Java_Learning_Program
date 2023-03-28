package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    private Team awayTeam;

    @Column(name = "home_team_goals")
    private int homeGoals;

    @Column(name = "away_team_goals")
    private int awayGoals;

    @Column(name = "date_time")
    private LocalDateTime dateAndTimeOfGame;

    @Column(name = "home_team_win_bet_rate")
    private double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private double awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate")
    private double drawGameBetRate;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;

    public Game() {

    }

}