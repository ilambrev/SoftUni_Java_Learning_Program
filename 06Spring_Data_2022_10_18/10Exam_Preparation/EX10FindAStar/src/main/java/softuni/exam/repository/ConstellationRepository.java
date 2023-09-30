package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.ConstellationEntity;

import java.util.Optional;

@Repository
public interface ConstellationRepository extends JpaRepository<ConstellationEntity, Long> {

    Optional<ConstellationEntity> findByName(String name);

}