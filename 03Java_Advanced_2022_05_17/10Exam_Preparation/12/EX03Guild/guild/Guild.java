package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }

        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                return;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = new ArrayList<>();
        List<Player> temp = new ArrayList<>();

        for (Player player : this.roster) {
            if (player.getClazz().equals(clazz)) {
                kickedPlayers.add(player);
            } else {
                temp.add(player);
            }
        }

        this.roster = temp;

        return kickedPlayers.toArray(new Player[0]);
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        return String.format("Players in the guild: %s:%n", this.name) +
                this.roster.stream().map(Player::toString).collect(Collectors.joining(System.lineSeparator()));
    }

}