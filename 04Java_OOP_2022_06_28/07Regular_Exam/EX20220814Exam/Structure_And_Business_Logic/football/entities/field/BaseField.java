package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;


    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return this.supplements;
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() == this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : this.players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder fieldInfo = new StringBuilder();

        fieldInfo.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());

        if (this.players.isEmpty()) {
            fieldInfo.append("Player: none").append(System.lineSeparator());
        } else {
            String playersInfo = this.players.stream().map(Player::getName).collect(Collectors.joining(" "));
            fieldInfo.append("Player: ").append(playersInfo).append(System.lineSeparator());
        }

        fieldInfo.append(String.format("Supplement: %d", this.supplements.size())).append(System.lineSeparator());

        fieldInfo.append(String.format("Energy: %d", sumEnergy()));

        return fieldInfo.toString().trim();
    }


}