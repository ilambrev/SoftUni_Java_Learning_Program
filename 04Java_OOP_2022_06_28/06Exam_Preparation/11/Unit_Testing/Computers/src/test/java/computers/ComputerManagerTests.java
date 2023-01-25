package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputerManagerTests {

    private ComputerManager computerManager;
    private Computer computer1;
    private Computer computer2;
    private Computer computer3;

    @Before
    public void setup() {
        computerManager = new ComputerManager();
        computer1 = new Computer("ASUS", "K555L", 1100.00);
        computer2 = new Computer("DELL", "Vostro", 1300.00);
        computer3 = new Computer("DELL", "Latitude", 1200.00);
    }

    @Test
    public void test_getCount_WithInsertedComputers() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);

        Assert.assertEquals(3, computerManager.getCount());
    }

    @Test
    public void test_getCount_WithoutInsertedComputers() {

        Assert.assertEquals(0, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addComputer_WithNullValueThrow() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addComputer_ThatAlreadyExists() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer1);
    }

    @Test
    public void test_addComputer_ThatNotExistsInComputerManager() {
        computerManager.addComputer(computer1);

        Assert.assertEquals(computer1, computerManager.getComputers().get(0));
    }

    @Test
    public void test_removeComputer() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);

        computerManager.removeComputer("DELL", "Vostro");

        Assert.assertNotEquals(computer2, computerManager.getComputers().get(1));

        Assert.assertEquals(2, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputer_WithNullValueOFManufacturer() {
        computerManager.getComputer(null, "Vostro");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputer_WithNullValueOFModel() {
        computerManager.getComputer("Dell", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputer_ThatNotExistsInComputerManager() {
        computerManager.getComputer("Lenovo", "ThinkPad");
    }

    @Test
    public void test_getComputer_ThatExistsInComputerManager() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);

        Assert.assertEquals(computer3, computerManager.getComputer("DELL", "Latitude"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputersByManufacturer_WithNullValueOfManufacturer() {
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void test_getComputersByManufacturer_ThatExistsInComputerManager() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);

        Assert.assertEquals(2, computerManager.getComputersByManufacturer("DELL").size());
    }

}