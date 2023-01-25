package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {

    private GiftFactory giftFactory;
    private Gift gift1;
    private Gift gift2;
    private Gift gift3;

    @Before
    public void setup() {
        this.giftFactory = new GiftFactory();
        this.gift1 = new Gift("Gift1", 10.5);
        this.gift2 = new Gift("Gift2", 30.5);
        this.gift3 = new Gift("Gift3", 20.5);
    }

    @Test
    public void testNumberOfGiftsInCollection() {
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);

        Assert.assertEquals(3, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertExistingGiftInCollection() {
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift1);
    }

    @Test
    public void testInsertNonExistingGiftInCollection() {

        double magic = 5.5;

        Gift gift = new Gift("Gift", magic);

        Assert.assertEquals(String.format("Successfully added gift Gift with magic %.2f.", magic), giftFactory.createGift(gift));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithEmptyName() {
        giftFactory.removeGift("");
    }

    @Test
    public void testRemoveGiftWithProperName() {
        giftFactory.createGift(gift1);

        Assert.assertTrue(giftFactory.removeGift("Gift1"));
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);

        Assert.assertEquals(gift1, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresentByName() {
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);

        Assert.assertEquals(gift2, giftFactory.getPresent("Gift2"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetGiftsUnmodifiableCollection() {
        giftFactory.getPresents().add(gift1);
    }

}
