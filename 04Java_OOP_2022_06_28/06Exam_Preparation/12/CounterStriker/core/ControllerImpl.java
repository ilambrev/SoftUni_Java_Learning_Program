package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {

    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;

        if ("Pistol".equals(type)) {
            gun = new Pistol(name, bulletsCount);
        } else if ("Rifle".equals(type)) {
            gun = new Rifle(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        guns.add(gun);

        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = guns.getModels().stream().filter(g -> g.getName().equals(gunName)).findFirst().orElse(null);

        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        Player player;

        if ("Terrorist".equals(type)) {
            player = new Terrorist(username, health, armor, gun);
        } else if ("CounterTerrorist".equals(type)) {
            player = new CounterTerrorist(username, health, armor, gun);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        players.add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {

        return this.field.start(players.getModels());
    }

    @Override
    public String report() {
        StringBuilder info = new StringBuilder();

        Comparator<Player> typeComparator = Comparator.comparing(p -> p.getClass().getSimpleName());

        List<Player> sorted = this.players.getModels().stream()
                .sorted(typeComparator.reversed().thenComparing(Player::getHealth).reversed().thenComparing(Player::getUsername))
                .collect(Collectors.toList());

        for (Player player : sorted) {
            info.append(player.toString()).append(System.lineSeparator());
        }

        return info.toString().trim();
    }

}