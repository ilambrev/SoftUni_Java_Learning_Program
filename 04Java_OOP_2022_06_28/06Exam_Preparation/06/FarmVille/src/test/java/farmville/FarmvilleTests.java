package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;
    private Animal animal1;
    private Animal animal2;
    private Animal animal3;

    @Before
    public void setup() {
        farm = new Farm("MyFarm", 2);
        animal1 = new Animal("Cat", 5);
        animal2 = new Animal("Dog", 12);
        animal3 = new Animal("Lizard", 3);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("MyFarm", farm.getName());
    }

    @Test
    public void testGetCount() {
        farm.add(animal1);
        farm.add(animal2);

        Assert.assertEquals(2, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_AnimalWhenFarmIsFullThrowsException() {
        farm.add(animal1);
        farm.add(animal2);
        farm.add(animal3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_AnimalThatIsAlreadyInFarmThrowsException() {
        farm.add(animal1);
        farm.add(animal1);
    }

    @Test
    public void testAdd_AnimalWhenFarmIsNotFullAndAnimalNotExistsInFarm() {
        farm.add(animal1);

        Assert.assertEquals(1, farm.getCount());
    }


    @Test
    public void testRemove_AnimalByTypeThatExists() {
        farm.add(animal1);
        farm.add(animal2);

        Assert.assertTrue(farm.remove(animal2.getType()));
    }

    @Test
    public void testRemove_AnimalByTypeThatNotExists() {
        farm.add(animal1);
        farm.add(animal2);

        Assert.assertFalse(farm.remove("Lion"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity_WithNegativeValueThrowsException() {
        Farm farm = new Farm("TestFarm", -1);
    }

    @Test
    public void testSetCapacity_WithPositiveValueThrowsException() {
        Farm farm = new Farm("TestFarm", 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetName_ThatIsNullThrowsException() {
        Farm farm = new Farm(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetName_ThatIsEmptyThrowsException() {
        Farm farm = new Farm("", 2);
    }

}