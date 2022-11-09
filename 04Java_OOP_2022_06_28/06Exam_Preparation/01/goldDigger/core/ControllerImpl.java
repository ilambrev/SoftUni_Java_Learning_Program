package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DiscovererRepository discoverers;
    private SpotRepository spots;
    private int spotsInspected;

    public ControllerImpl() {
        this.discoverers = new DiscovererRepository();
        this.spots = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;

        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        discoverers.add(discoverer);

        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        spots.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {

        boolean removeSucceeded = this.discoverers.remove(this.discoverers.byName(discovererName));

        if (removeSucceeded) {
            return String.format(DISCOVERER_EXCLUDE, discovererName);
        } else {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

    }

    @Override
    public String inspectSpot(String spotName) {

        List<Discoverer> suitable_discoverers = this.discoverers.getCollection().stream()
                .filter(e -> e.getEnergy() > 45)
                .collect(Collectors.toList());

        if (suitable_discoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        } else {
            Spot spot = spots.getCollection().stream().filter(s -> s.getName().equals(spotName)).findFirst().orElse(null);

            Operation operation = new OperationImpl();
            operation.startOperation(spot, suitable_discoverers);
        }

        long excluded_discoverers = 0;

        for (Discoverer discoverer : suitable_discoverers) {
            if (!discoverer.canDig()) {
                excluded_discoverers++;
            }
        }

        spotsInspected++;

        return String.format(INSPECT_SPOT, spotName, excluded_discoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder stats = new StringBuilder();

        stats.append(String.format(FINAL_SPOT_INSPECT, spotsInspected)).append(System.lineSeparator());

        stats.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());

        for (Discoverer discoverer : this.discoverers.getCollection()) {
            stats.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator());
            stats.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());

            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                stats.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                stats.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, (String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,
                        discoverer.getMuseum().getExhibits())))).append(System.lineSeparator());
            }
        }

        return stats.toString().trim();
    }

}