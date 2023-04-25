package bg.softuni.L02Spring_Data.cats.service.imp;

import bg.softuni.L02Spring_Data.cats.model.dto.CreateOwnerDTO;
import bg.softuni.L02Spring_Data.cats.model.entity.CatEntity;
import bg.softuni.L02Spring_Data.cats.model.entity.OwnerEntity;
import bg.softuni.L02Spring_Data.cats.repository.OwnerRepository;
import bg.softuni.L02Spring_Data.cats.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void createOwner(CreateOwnerDTO createOwnerDTO) {

        OwnerEntity owner = new OwnerEntity().setOwnerName(createOwnerDTO.getOwnerName());

        createOwnerDTO.getCatNames().forEach(name -> {
            CatEntity cat = new CatEntity().setCatName(name).setOwner(owner);
            owner.addCat(cat);
        });

        this.ownerRepository.save(owner);

    }

}