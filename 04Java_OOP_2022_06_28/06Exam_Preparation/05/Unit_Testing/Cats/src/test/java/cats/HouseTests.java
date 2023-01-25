package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;
    private Cat cat1;
    private Cat cat2;
    private Cat cat3;
    private static final int CAPACITY = 2;

    @Before
    public void setup() {
        house = new House("CatHouse", CAPACITY);
        cat1 = new Cat("Maca");
        cat2 = new Cat("Gosho");
        cat3 = new Cat("Sisho");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("CatHouse", this.house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetName_ThatIsEmptyHouseNameAndThrowsException() {
        House house = new House("", CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testSetName_ThatIsNullHouseNameAndThrowsException() {
        House house = new House(null, CAPACITY);
    }

    @Test
    public void testSetName_ThatIsProperHouseName() {
        House house = new House("NewCatHouse", CAPACITY);

        Assert.assertEquals("NewCatHouse", house.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(CAPACITY, this.house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity_ThatIsNegativeAndThrowsException() {
        int negativeCapacity = -1;
        House house = new House("Cats", negativeCapacity);
    }

    @Test
    public void testSetCapacity_WithProperPositiveValue() {
        int capacity = 5;

        House newHouse = new House("Big Cat House", 5);

        Assert.assertEquals(5, newHouse.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCat_WithNumberOfCatsMoreThanHouseCapacityThrowsException() {
        this.house.addCat(cat1);
        this.house.addCat(cat2);
        this.house.addCat(cat3);
    }

    @Test
    public void testAddCat_WithNumberOfCatsThatIsEqualToCapacity() {
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        Assert.assertEquals(2, this.house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCat_WithNonExistingNameThrowsException() {
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        this.house.removeCat("Sisho");
    }

    @Test
    public void testRemoveCat_WithExistingName() {
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        String catThatRemainInHouse = cat1.getName();
        String catNameToRemove = cat2.getName();

        this.house.removeCat(catNameToRemove);

        Assert.assertEquals(1, this.house.getCount());
        Assert.assertEquals(cat1, this.house.catForSale(catThatRemainInHouse));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSale_WithNonExistingNameThrowsException() {
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        this.house.catForSale("Sisho");
    }

    @Test
    public void testCatForSale_WithExistingName() {
        this.house.addCat(cat1);
        this.house.addCat(cat2);

        String catNameToTest = cat2.getName();

        Assert.assertEquals(cat2, this.house.catForSale(catNameToTest));
        Assert.assertFalse(cat2.isHungry());
    }

    @Test
    public void test_Statistics() {
        this.house.addCat(cat1);
        String expectedText = "The cat Maca is in the house CatHouse!";

        Assert.assertEquals(expectedText, this.house.statistics());
    }

    @Test
    public void testSetHungry_WithCatStatusHungry() {
        cat1.setHungry(true);

        Assert.assertTrue(cat1.isHungry());
    }

}