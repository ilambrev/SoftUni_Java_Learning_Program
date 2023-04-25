package bg.softuni.L01Spring_IoC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {

//    @Primary // Used when there are multiple Beans of same type
    @Bean("normalDog") // Assign name to Bean
    public Animal dog() {
        return new Dog();
    }

    @Bean("superDog") // Assign name to Bean - by default the name is same as name of method
    public Animal superDog() {
        return new Dog(true);
    }

    @Bean // By default, the name is same as name of method
    public Animal cat() {
        return new Cat();
    }

}