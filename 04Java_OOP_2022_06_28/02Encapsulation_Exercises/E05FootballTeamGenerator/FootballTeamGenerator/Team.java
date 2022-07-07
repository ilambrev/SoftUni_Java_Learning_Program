package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.length() == 0 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                this.players.remove(player);
                return;
            }
        }
        throw new IllegalArgumentException("Player " + name + " is not in " + this.name + " team.");
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.0);
    }

}