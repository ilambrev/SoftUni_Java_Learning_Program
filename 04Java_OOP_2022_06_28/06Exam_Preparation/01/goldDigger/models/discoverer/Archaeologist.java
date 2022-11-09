package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer {

    private static final double ARCHAEOLOGIST_ENERGY = 60.00;

    public Archaeologist(String name) {
        super(name, ARCHAEOLOGIST_ENERGY);
    }

}