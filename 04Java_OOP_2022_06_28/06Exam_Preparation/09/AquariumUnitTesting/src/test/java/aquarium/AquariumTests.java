package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private Aquarium aquarium;
    private Fish fish1;
    private Fish fish2;
    private Fish fish3;

    @Before
    public void setup() {
        aquarium = new Aquarium("Varna", 2);
        fish1 = new Fish("Gosho");
        fish2 = new Fish("Pesho");
        fish3 = new Fish("Tosho");
    }

    @Test(expected = NullPointerException.class)
    public void test_SetNewAquariumWithNullName() {
        Aquarium aquarium1 = new Aquarium(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void test_SetNewAquariumWithEmptyName() {
        Aquarium aquarium1 = new Aquarium("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetNewAquariumWithNegativeCapacity() {
        Aquarium aquarium1 = new Aquarium("Test", -1);
    }

    @Test
    public void test_getCount_WithEmptyAquarium() {

        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_add_WithFishNumberOverAquariumCapacity() {
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
    }

    @Test
    public void test_add_WithFishNumberThatIsEqualToAquariumCapacity() {
        aquarium.add(fish1);
        aquarium.add(fish2);

        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_remove_FishWithNameThatDoNotExistInAquarium() {
        aquarium.add(fish1);
        aquarium.add(fish2);

        aquarium.remove("Nemo");
    }

    @Test
    public void test_remove_FishWithNameThatExistsInAquarium() {
        aquarium.add(fish1);
        aquarium.add(fish2);

        aquarium.remove("Gosho");

        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_sellFish_WithNameThatDoNotExistInAquarium() {
        aquarium.add(fish1);
        aquarium.add(fish2);

        aquarium.sellFish("Nemo");
    }

    @Test
    public void test_sellFish_WithNameThatExistsInAquarium() {
        aquarium.add(fish1);
        aquarium.add(fish2);

        aquarium.sellFish("Gosho");

        Assert.assertFalse(fish1.isAvailable());
    }

    @Test
    public void test_report() {
        String expectedReport = "Fish available at Varna: Gosho";

        aquarium.add(fish1);

        String getByMethodReport = aquarium.report();

        Assert.assertEquals(expectedReport, getByMethodReport);
    }

}