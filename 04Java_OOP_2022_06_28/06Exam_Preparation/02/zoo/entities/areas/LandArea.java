package zoo.entities.areas;

public class LandArea extends BaseArea {

    private final static int CAPACITY = 25;

    public LandArea(String name) {
        super(name, CAPACITY);
    }

}