package bg.softuni.L01Spring_IoC;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PostConstruct;

public class Dog implements Animal, BeanNameAware, DisposableBean {

    private final boolean superDog;

    public Dog() {
        this(false);
    }

    public Dog(boolean superDog) {
        this.superDog = superDog;
    }

    @Override
    public void makeNoise() {

        String noise = this.superDog ? "Super bark, super bark!!!" : "Bark, bark!!!";

        System.out.println(noise);
    }

    // Shows Bean initialization. Can be used for DB initialization for example
    @PostConstruct
    public void afterInit() {
        System.out.println("Dog is ready to bite!!!");
    }

    // Shows the Bean name
    @Override
    public void setBeanName(String name) {
        System.out.println("The name of this Dog bean is: " + name);
    }

    // Shows Bean destroying when application is shutting down
    // To see the message in IntelliJ IDEA Console, have to use "Exit" instead of "Stop" when stopping the application
    // It is the same as using @PreDestroy
    @Override
    public void destroy() throws Exception {
        System.out.println("Dog is about to die... Bye!");
    }

}