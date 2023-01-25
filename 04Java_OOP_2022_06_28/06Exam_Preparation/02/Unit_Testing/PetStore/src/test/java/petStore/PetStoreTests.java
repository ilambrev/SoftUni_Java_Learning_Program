package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PetStoreTests {
    private PetStore petStore;
    private Animal animal1;
    private Animal animal2;
    private Animal animal3;

    @Before
    public void setup() {
        petStore = new PetStore();
        animal1 = new Animal("Bear", 100, 5000.00);
        animal2 = new Animal("Fox", 10, 2000.00);
        animal3 = new Animal("Frog", 1, 500.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void changeUnmodifiableList() {
        petStore.getAnimals().add(animal1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalProperly() {

        petStore.addAnimal(null);
    }

    @Test
    public void countAnimalsInStore() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(3, petStore.getCount());
    }

    @Test
    public void testAnimalWithMaxKG() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(animal1.getMaxKilograms(), petStore.findAllAnimalsWithMaxKilograms(20).get(0).getMaxKilograms());
    }

    @Test
    public void testFindMostExpensiveAnimal() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(animal1.getPrice(), petStore.getTheMostExpensiveAnimal().getPrice(), 0.001);
    }

    @Test
    public void testFindAnimalBySpecie() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(animal1.getSpecie(), petStore.findAllAnimalBySpecie("Bear").get(0).getSpecie());
    }

}
