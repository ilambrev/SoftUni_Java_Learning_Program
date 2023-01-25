package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ShopTest {

    Shop shop;
    Goods apples;
    Goods bananas;
    Goods grapes;

    @Before
    public void setup() {
        this.shop = new Shop();
        apples = new Goods("Apples", "AP");
        bananas = new Goods("Bananas", "BN");
        grapes = new Goods("Grapes", "GR");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getShelves_DeleteShelfFromUnmodifiableMapThrow() {
        shop.getShelves().remove("Shelves1");
    }

    @Test
    public void test_getShelves() {
        Assert.assertEquals(12, shop.getShelves().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addGoods_OnNotExistingShelfThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves15", apples);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addGoods_OnTakenShelfThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", apples);
        shop.addGoods("Shelves1", bananas);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_addGoods_ThatAlreadyInShelvesThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", apples);
        shop.addGoods("Shelves2", apples);
    }

    @Test
    public void test_addGoods_ThatNotPresentInShelvesAndThatIsAddInExistingEmptyShelf() throws OperationNotSupportedException {
        String methodMessage = shop.addGoods("Shelves5", apples);

        String expectedMessage = String.format("Goods: %s is placed successfully!", apples.getGoodsCode());

        Assert.assertEquals(expectedMessage, methodMessage);

        Assert.assertTrue(shop.getShelves().containsValue(apples));

        Assert.assertEquals(apples, shop.getShelves().get("Shelves5"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeGoods_FromNotExistingShelfThrow() throws OperationNotSupportedException {
        shop.removeGoods("Shelves15", apples);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeGoods_ThatNotPresentInExistingShelfThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", apples);
        shop.removeGoods("Shelves1", bananas);
    }

    @Test
    public void test_removeGoods_ThatIsPresentInExistingShelfThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", apples);

        String methodMessage = shop.removeGoods("Shelves1", apples);

        String expectedMessage = String.format("Goods: %s is removed successfully!", apples.getGoodsCode());

        Assert.assertEquals(expectedMessage, methodMessage);

        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

}