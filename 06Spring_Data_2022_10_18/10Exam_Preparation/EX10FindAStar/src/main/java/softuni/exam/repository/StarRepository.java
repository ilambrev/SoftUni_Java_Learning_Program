package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.StarEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<StarEntity, Long> {

    Optional<StarEntity> findByName(String name);

    @Query(value = "SELECT s FROM StarEntity AS s " +
            "WHERE s.starType = 'RED_GIANT' " +
            "AND s.id NOT IN " +
            "(SELECT a.observingStar FROM AstronomerEntity AS a)" +
            "ORDER BY s.lightYears ASC")
    List<StarEntity> findByLightYears();

}