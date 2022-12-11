package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;

public interface Field {
    String start(Collection<Player> players);
}
