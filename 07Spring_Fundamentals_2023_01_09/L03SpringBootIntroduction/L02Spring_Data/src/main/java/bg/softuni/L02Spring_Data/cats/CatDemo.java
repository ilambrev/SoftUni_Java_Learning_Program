package bg.softuni.L02Spring_Data.cats;

import bg.softuni.L02Spring_Data.cats.model.dto.CreateOwnerDTO;
import bg.softuni.L02Spring_Data.cats.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatDemo implements CommandLineRunner {

    private final OwnerService ownerService;

    @Autowired
    public CatDemo(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.ownerService.createOwner(new CreateOwnerDTO().
                setOwnerName("Ivan").
                setCatNames(List.of("Shushi", "Tom", "Matca")));
    }

}