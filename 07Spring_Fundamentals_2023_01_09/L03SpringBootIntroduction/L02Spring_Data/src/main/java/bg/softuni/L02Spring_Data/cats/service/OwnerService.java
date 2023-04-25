package bg.softuni.L02Spring_Data.cats.service;

import bg.softuni.L02Spring_Data.cats.model.dto.CreateOwnerDTO;

public interface OwnerService {

    void createOwner(CreateOwnerDTO createOwnerDTO);

}