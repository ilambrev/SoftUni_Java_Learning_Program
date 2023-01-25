package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {

    private Garage garage;
    private Car vw;
    private Car mercedes;
    private Car renault;
    private static final int MAX_SPEED = 210;

    @Before
    public void setup() {
        garage = new Garage();
        vw = new Car("VW", 200, 40000);
        mercedes = new Car("Mercedes", 220, 80000);
        renault = new Car("Renault", 180, 30000);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_Modify_Returned_Unmodified_Collection_Of_cars() {
        garage.addCar(vw);
        garage.addCar(mercedes);
        garage.addCar(renault);

        garage.getCars().remove(0);
    }

    @Test
    public void test_Count_Cars_In_Garage_Collection() {
        garage.addCar(vw);
        garage.addCar(mercedes);
        garage.addCar(renault);

        int numberOfAddedCars = 3;

        Assert.assertEquals(numberOfAddedCars, garage.getCount());
    }

    @Test
    public void test_Find_All_Cars_With_MaxSpeed_Above() {
        garage.addCar(vw);
        garage.addCar(mercedes);
        garage.addCar(renault);

        Assert.assertEquals(mercedes, garage.findAllCarsWithMaxSpeedAbove(MAX_SPEED).get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Car_With_Null_Value() {
        garage.addCar(null);
    }

    @Test
    public void test_Get_The_Most_Expensive_Car() {
        garage.addCar(vw);
        garage.addCar(mercedes);
        garage.addCar(renault);

        Assert.assertEquals(mercedes, garage.getTheMostExpensiveCar());
    }

    @Test
    public void test_Find_All_Cars_By_Brand() {
        garage.addCar(vw);
        garage.addCar(mercedes);
        garage.addCar(renault);

        Assert.assertEquals(renault, garage.findAllCarsByBrand("Renault").get(0));
    }

}