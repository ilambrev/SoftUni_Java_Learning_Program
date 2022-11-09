package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        for (Discoverer discoverer : discoverers) {
            if (spot.getExhibits().isEmpty()) {
                break;
            }

            while(discoverer.canDig() && !spot.getExhibits().isEmpty()) {
                for (String exhibit : new ArrayList<>(spot.getExhibits())) {
                    discoverer.dig();
                    discoverer.getMuseum().getExhibits().add(exhibit);
                    spot.getExhibits().remove(exhibit);
                    if (!discoverer.canDig()) {
                        break;
                    }
                }
            }
        }

    }

}