package bg.softuni.ex20230218reseller.repositories;

import bg.softuni.ex20230218reseller.models.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Query(value = "SELECT o FROM OfferEntity AS o " +
            "JOIN o.user.offers AS a " +
            "ON o.id = a.id " +
            "WHERE o.user.id <> :id")
    List<OfferEntity> findAvailable(Long id);

}