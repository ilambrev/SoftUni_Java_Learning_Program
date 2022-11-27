package viceCity.core;


import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayList;
import java.util.Collection;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Player mainPlayer;
    private Collection<Player> players;
    private GunRepository guns;
    private GangNeighbourhood gangNeighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new ArrayList<>();
        this.guns = new GunRepository();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);

        this.players.add(player);

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;

        if ("Pistol".equals(type)) {
            gun = new Pistol(name);
        } else if ("Rifle".equals(type)) {
            gun = new Rifle(name);
        } else {
            return GUN_TYPE_INVALID;
        }

        guns.add(gun);

        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.getGuns().isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gun = guns.getGuns().stream().findFirst().orElse(null);

        assert gun != null;

        if ("Vercetti".equals(name)) {
            mainPlayer.getGunRepository().add(gun);
            guns.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        Player player = players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);

        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        player.getGunRepository().add(gun);
        guns.remove(gun);

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        StringBuilder fightResult = new StringBuilder();
        int initialPlayersCount = players.size();

        gangNeighbourhood.action(mainPlayer, players);

        if (mainPlayer.getLifePoints() == 100 && players.size() == initialPlayersCount) {
            fightResult.append(FIGHT_HOT_HAPPENED);
        } else {

            fightResult.append(FIGHT_HAPPENED).append(System.lineSeparator());
            fightResult.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
            fightResult.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, initialPlayersCount - players.size())).append(System.lineSeparator());
            fightResult.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, players.size()));
        }

        return fightResult.toString().trim();
    }

}