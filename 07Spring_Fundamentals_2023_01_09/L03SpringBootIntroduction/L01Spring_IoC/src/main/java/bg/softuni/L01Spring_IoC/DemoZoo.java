package bg.softuni.L01Spring_IoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoZoo implements CommandLineRunner {

    private final ZooService zooService;

    @Autowired
    public DemoZoo(ZooService zooService) {
        this.zooService = zooService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.zooService.doWork();
    }

}