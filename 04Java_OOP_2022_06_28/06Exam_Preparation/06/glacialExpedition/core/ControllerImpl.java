package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorers;
    private StateRepository states;
    private int exploredStates;

    public ControllerImpl() {
        this.explorers = new ExplorerRepository();
        this.states = new StateRepository();
        this.exploredStates = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        if (!"AnimalExplorer".equals(type) && !"GlacierExplorer".equals(type) && !"NaturalExplorer".equals(type)) {
            throw new IllegalArgumentException("Explorer type doesn't exists.");
        } else {
            Explorer explorer;

            if ("AnimalExplorer".equals(type)) {
                explorer = new AnimalExplorer(explorerName);
            } else if ("GlacierExplorer".equals(type)) {
                explorer = new GlacierExplorer(explorerName);
            } else {
                explorer = new NaturalExplorer(explorerName);
            }

            explorers.add(explorer);
        }

        return String.format("Added %s: %s.", type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {

        State state = new StateImpl(stateName);

        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        this.states.add(state);

        return String.format("Added state: %s.", stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {

        Explorer explorer = explorers.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format("Explorer %s doesn't exists.", explorerName));
        } else {
            explorers.remove(explorer);
        }

        return String.format("Explorer %s has retired!", explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = this.states.byName(stateName);

        List<Explorer> suitableExplorers = this.explorers.getCollection()
                .stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());

        if (suitableExplorers.isEmpty()) {
            throw new IllegalArgumentException("You must have at least one explorer to explore the state.");
        } else {
            Mission mission = new MissionImpl();
            mission.explore(state, suitableExplorers);
        }

        int retiredExplorers = 0;

        for (Explorer explorer : suitableExplorers) {
            if (!explorer.canSearch()) {
                retireExplorer(explorer.getName());
                retiredExplorers++;
            }
        }

        this.exploredStates++;

        states.remove(state);

        return String.format("The state %s was explored. %d researchers have retired on this mission.", stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder info = new StringBuilder();

        DecimalFormat df = new DecimalFormat("#.##");

        info.append(String.format("%d states were explored.", this.exploredStates)).append(System.lineSeparator());

        info.append("Information for the explorers:").append(System.lineSeparator());

        for (Explorer explorer : explorers.getCollection()) {
            info.append(String.format("Name: %s", explorer.getName())).append(System.lineSeparator());
            info.append(String.format("Energy: %s", df.format(explorer.getEnergy()))).append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                info.append("Suitcase exhibits: None").append(System.lineSeparator());
            } else {
                info.append("Suitcase exhibits: ");
                info.append(String.join(", ", explorer.getSuitcase().getExhibits())).append(System.lineSeparator());
            }
        }

        return info.toString().trim();
    }

}