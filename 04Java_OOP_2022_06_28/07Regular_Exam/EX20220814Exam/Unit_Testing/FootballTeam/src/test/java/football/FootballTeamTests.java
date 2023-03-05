package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FootballTeamTests {

    private FootballTeam footballTeam;
    private Footballer footballer1;
    private Footballer footballer2;
    private Footballer footballer3;

    @Before
    public void setup() {
        this.footballTeam = new FootballTeam("Loko", 2);
        footballer1 = new Footballer("Pesho");
        footballer2 = new Footballer("Gosho");
        footballer3 = new Footballer("Tosho");
    }

    @Test(expected = NullPointerException.class)
    public void test_setName_With_Null_Value_Throw() {
        FootballTeam footballTeam1 = new FootballTeam(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_setName_With_Empty_Value_Throw() {
        FootballTeam footballTeam1 = new FootballTeam("", 2);
    }

    @Test
    public void test_setName_With_NotNull_And_Not_Empty_Value() {
        FootballTeam footballTeam1 = new FootballTeam("Ivan", 2);

        Assert.assertEquals("Ivan", footballTeam1.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setVacantPositions_With_Negative_Value_Throw() {
        FootballTeam footballTeam1 = new FootballTeam("Ivan", -1);
    }

    @Test
    public void test_setVacantPositions_With_Positive_Value_Throw() {
        FootballTeam footballTeam1 = new FootballTeam("Ivan", 2);

        Assert.assertEquals(2, footballTeam1.getVacantPositions());
    }

    @Test
    public void test_getCount_With_Two_Footballers() {
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        Assert.assertEquals(2, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addFootballer_When_Capacity_Is_Full_Throw() {
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
    }

    @Test
    public void test_addFootballer_When_Capacity_Is_Not_Full() {
        footballTeam.addFootballer(footballer1);

        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeFootballer_By_Name_That_Not_Exists_Throw() {
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        footballTeam.removeFootballer("Ivan");
    }

    @Test
    public void test_removeFootballer_By_Name_That_Exists_Throw() {
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        footballTeam.removeFootballer("Gosho");

        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_footballerForSale_By_Name_That_Not_Exists_Throw() {
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        footballTeam.footballerForSale("Ivan");
    }

    @Test
    public void test_footballerForSale_By_Name_That_Exists_Throw() {
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        Assert.assertEquals(footballer2, footballTeam.footballerForSale("Gosho"));

        Assert.assertFalse(footballer2.isActive());
    }

    @Test
    public void test_getStatistics() {
        footballTeam.addFootballer(footballer1);
        String expectedMessage = String.format("The footballer %s is in the team %s.", footballer1.getName(), footballTeam.getName());

        Assert.assertEquals(expectedMessage, footballTeam.getStatistics());
    }

}