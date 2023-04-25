package bg.softuni.L01Spring_IoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

    //For one Animal Bean in ZooConfig

//    private final Animal animal;
//
//    @Autowired
//    public ZooService(Animal animal) {
//        this.animal = animal;
//    }
//
//    public void doWork() {
//        animal.makeNoise();
//    }

    // For multiple Animal Beans in ZooConfig and @Primary on one of the Beans

//    private final List<Animal> animals;
//
//    @Autowired
//    public ZooService(List<Animal> animals) {
//        this.animals = animals;
//    }
//
//    public void doWork() {
//        this.animals.forEach(Animal::makeNoise);
//    }

    //    For multiple Animal Beans in ZooConfig and @Primary on one of the Beans

    private final Animal animal1;
    private final Animal animal2;
    private final Animal animal3;

    @Autowired
    public ZooService(@Qualifier("normalDog") Animal animal1,
                      @Qualifier("superDog") Animal animal2,
                      @Qualifier("cat") Animal animal3) {
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.animal3 = animal3;
    }

    public void doWork() {
        animal1.makeNoise();
        animal2.makeNoise();
        animal3.makeNoise();
    }

}