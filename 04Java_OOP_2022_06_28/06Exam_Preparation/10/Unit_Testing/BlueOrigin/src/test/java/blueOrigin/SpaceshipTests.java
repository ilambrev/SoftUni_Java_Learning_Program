package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    private Spaceship spaceship;
    private Astronaut astronaut1;
    private Astronaut astronaut2;
    private Astronaut astronaut3;

    @Before
    public void setup() {
        this.spaceship = new Spaceship("Apolo", 2);
        this.astronaut1 = new Astronaut("Pesho", 80.0);
        this.astronaut2 = new Astronaut("Gosho", 90.0);
        this.astronaut3 = new Astronaut("Spas", 70.0);
    }

    @Test
    public void test_getCount() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);

        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test_setName_WithNullValueThrow() {
        Spaceship testSpaceship = new Spaceship(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_setName_WithEmptyValueThrow() {
        Spaceship testSpaceship = new Spaceship("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setCapacity_WithNegativeValueThrow() {
        Spaceship testSpaceship = new Spaceship("SpaceFlagman", -1);
    }

    @Test
    public void test_getCapacity() {
        Assert.assertEquals(2, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_add_MoreAstronautsThanSpaceshipCapacityThrow() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_add_AstronautThatExistsInSpaceshipThrow() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }

    @Test
    public void test_add_AstronautThatNotExistsInSpaceship() {
        spaceship.add(astronaut1);

        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void test_remove_AstronautByNameThatExistsInSpaceship() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);

        Assert.assertTrue(spaceship.remove("Gosho"));
        Assert.assertEquals(1, spaceship.getCount());
    }

}
