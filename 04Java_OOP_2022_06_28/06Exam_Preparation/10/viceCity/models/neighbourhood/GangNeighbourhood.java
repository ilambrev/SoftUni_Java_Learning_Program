package viceCity.models.neighbourhood;


import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player player : new ArrayList<>(civilPlayers)) {
            for (Gun gun : mainPlayer.getGunRepository().getGuns()) {
                if (!gun.canFire()) {
                    continue;
                }

                while (gun.canFire()) {
                    int lifePoints = gun.fire();
                    player.takeLifePoints(lifePoints);
                    if (!player.isAlive()) {
                        civilPlayers.remove(player);
                        break;
                    }
                }

                if (!player.isAlive()) {
                    break;
                }
            }
        }

        for (Player player : new ArrayList<>(civilPlayers)) {
            for (Gun gun : player.getGunRepository().getGuns()) {
                if (!gun.canFire()) {
                    continue;
                }

                while (gun.canFire()) {
                    int lifePoints = gun.fire();
                    mainPlayer.takeLifePoints(lifePoints);
                    if (!mainPlayer.isAlive()) {
                        return;
                    }
                }

            }
        }

    }

}