package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("Terrorist")).collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("CounterTerrorist")).collect(Collectors.toList());

        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()) {
            for (Player terrorist : terrorists) {
                for (Player counterTerrorist : new ArrayList<>(counterTerrorists)) {
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                    if (!counterTerrorist.isAlive()) {
                        counterTerrorists.remove(counterTerrorist);
                    }
                }
            }

            for (Player counterTerrorist : counterTerrorists) {
                for (Player terrorist : new ArrayList<>(terrorists)) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                    if (!terrorist.isAlive()) {
                        terrorists.remove(terrorist);
                    }
                }
            }

        }

        if (terrorists.isEmpty()) {
            return COUNTER_TERRORIST_WINS;
        } else {
            return TERRORIST_WINS;
        }
    }

}