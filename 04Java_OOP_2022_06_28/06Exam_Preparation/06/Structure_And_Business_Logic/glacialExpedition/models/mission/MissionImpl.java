package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        for (Explorer explorer : explorers) {

            if (state.getExhibits().isEmpty()) {
                break;
            }

            while (explorer.canSearch() && !state.getExhibits().isEmpty()) {
                for (String exhibit : state.getExhibits()) {
                    explorer.search();
                    explorer.getSuitcase().getExhibits().add(exhibit);
                    if (!explorer.canSearch()) {
                        break;
                    }
                }
                for (String exhibit : explorer.getSuitcase().getExhibits()) {
                    state.getExhibits().remove(exhibit);
                }
            }

        }
    }

}
