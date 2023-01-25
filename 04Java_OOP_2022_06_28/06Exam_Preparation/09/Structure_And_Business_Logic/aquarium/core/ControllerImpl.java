package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {

        Aquarium aquarium;

        if ("FreshwaterAquarium".equals(aquariumType)) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if ("SaltwaterAquarium".equals(aquariumType)) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException("Invalid aquarium type.");
        }

        this.aquariums.add(aquarium);

        return String.format("Successfully added %s.", aquariumType);
    }

    @Override
    public String addDecoration(String type) {

        Decoration decoration;

        if ("Ornament".equals(type)) {
            decoration = new Ornament();
        } else if ("Plant".equals(type)) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException("Invalid decoration type.");
        }

        this.decorations.add(decoration);

        return String.format("Successfully added %s.", type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Decoration decoration = this.decorations.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format("There isn't a decoration of type %s.", decorationType));
        }

        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

        assert aquarium != null;
        aquarium.addDecoration(decoration);
        decorations.remove(decoration);

        return String.format("Successfully added %s to %s.", decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {

        Fish fish;

        if ("FreshwaterFish".equals(fishType)) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if ("SaltwaterFish".equals(fishType)) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException("Invalid fish type.");
        }

        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

        assert aquarium != null;
        if (("FreshwaterFish".equals(fish.getClass().getSimpleName()) && "FreshwaterAquarium".equals(aquarium.getClass().getSimpleName())) ||
                ("SaltwaterFish".equals(fish.getClass().getSimpleName()) && "SaltwaterAquarium".equals(aquarium.getClass().getSimpleName()))) {
            aquarium.addFish(fish);
        } else {
            return "Water not suitable.";
        }

        return String.format("Successfully added %s to %s.", fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {

        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

        assert aquarium != null;

        aquarium.feed();

        return String.format("Fish fed: %d", aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {

        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

        assert aquarium != null;

        double fishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();

        double decorationPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        double aquariumValue = fishPrice + decorationPrice;

        return String.format("The value of Aquarium %s is %.2f.", aquariumName, aquariumValue);
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();

        for (Aquarium aquarium : this.aquariums) {
            report.append(aquarium.getInfo()).append(System.lineSeparator());
        }

        return report.toString().trim();
    }

}