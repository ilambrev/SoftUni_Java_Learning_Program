package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.AstronomerEntity;

import java.util.Optional;

@Repository
public interface AstronomerRepository extends JpaRepository<AstronomerEntity, Long> {

    Optional<AstronomerEntity> findByFirstNameAndLastName(String firstName, String lastName);

}