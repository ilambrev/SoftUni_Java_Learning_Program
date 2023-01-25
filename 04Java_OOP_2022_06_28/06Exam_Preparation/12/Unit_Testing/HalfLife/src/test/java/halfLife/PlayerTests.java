package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {

    private Player player;
    private Gun gun1;
    private Gun gun2;
    private Gun gun3;

    @Before
    public void setup() {
        player = new Player("Pesho", 15);
        gun1 = new Gun("Pistol", 10);
        gun2 = new Gun("Rifle", 30);
        gun3 = new Gun("Gun", 15);
    }

    @Test(expected = NullPointerException.class)
    public void test_setName_ThatIsNullThrow() {
        Player testPlayer = new Player(null, 25);
    }

    @Test(expected = NullPointerException.class)
    public void test_setName_ThatIsEmptyThrow() {
        Player testPlayer = new Player("", 25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setHealth_WithNegativeValueThrow() {
        Player testPlayer = new Player("John", -1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getGuns_TryToChangeCollectionThrow() {
        player.getGuns().add(gun1);
    }

    @Test(expected = IllegalStateException.class)
    public void test_takeDamage_OnDeathPlayerThrow() {
        Player testPlayer = new Player("Goran", 0);
        testPlayer.takeDamage(5);
    }

    @Test
    public void test_takeDamage_OnPlayerWithPositiveValueOfHealthBiggerThanPlayerHealth() {
        player.takeDamage(20);

        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void test_takeDamage_OnPlayerWithPositiveValueOfHealthSmallerThanPlayerHealth() {
        player.takeDamage(10);

        Assert.assertEquals(5, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void test_addGun_WithNullalueThrow() {

        player.addGun(null);
    }

    @Test
    public void test_addGun_WithValidValue() {
        ;
        player.addGun(gun1);
        player.addGun(gun2);
        player.addGun(gun3);

        Assert.assertEquals(3, player.getGuns().size());
    }

    @Test
    public void test_removeGun_WithExistingGun() {
        player.addGun(gun1);
        player.addGun(gun2);
        player.addGun(gun3);

        Assert.assertTrue(player.removeGun(gun3));
        Assert.assertEquals(2, player.getGuns().size());
    }

    @Test
    public void test_getGun_WithExistingName() {
        player.addGun(gun1);
        player.addGun(gun2);
        player.addGun(gun3);

        Assert.assertEquals(gun2, player.getGun("Rifle"));
    }

}