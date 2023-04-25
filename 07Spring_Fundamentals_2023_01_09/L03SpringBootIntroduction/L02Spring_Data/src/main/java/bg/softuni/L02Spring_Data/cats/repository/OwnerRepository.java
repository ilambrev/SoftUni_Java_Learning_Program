package bg.softuni.L02Spring_Data.cats.repository;

import bg.softuni.L02Spring_Data.cats.model.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {

}