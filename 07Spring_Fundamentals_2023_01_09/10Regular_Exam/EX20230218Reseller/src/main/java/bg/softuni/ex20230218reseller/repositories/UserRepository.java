package bg.softuni.ex20230218reseller.repositories;

import bg.softuni.ex20230218reseller.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findFirstByUsername(String username);

    Optional<UserEntity> findFirstByEmail(String email);

}