package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;

    @Before
    public void setup() {
        heroRepository = new HeroRepository();
        hero1 = new Hero("Ivan", 5);
        hero2 = new Hero("Peter", 3);
        hero3 = new Hero("Boris", 4);
    }

    @Test(expected = NullPointerException.class)
    public void test_create_HeroWithNullValueThrow() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_create_HeroThatAlreadyExistsInHeroRepository() {
        heroRepository.create(hero1);
        heroRepository.create(hero1);
    }

    @Test
    public void test_create_HeroThatNotExistsInHeroRepository() {

        String messageExpected = "Successfully added hero Ivan with level 5";
        String messageFromMethod = heroRepository.create(hero1);

        Assert.assertEquals(messageExpected, messageFromMethod);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test_remove_HeroWithNullNameValueThrow() {
        heroRepository.remove(null);
    }

    @Test
    public void test_remove_HeroWithNameThatExistsInHeroRepository() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);

        Assert.assertTrue(heroRepository.remove("Peter"));

        Assert.assertEquals(2, heroRepository.getCount());
    }

    @Test
    public void test_getHeroWithHighestLevel() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);

        Assert.assertEquals(hero1, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void test_getHero() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);

        Assert.assertEquals(hero2, heroRepository.getHero("Peter"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getHeroes_TryToChangeCollection() {
        this.heroRepository.getHeroes().add(hero1);
    }

}
