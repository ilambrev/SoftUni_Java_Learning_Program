package com.likebookapp.repository;

import com.likebookapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameOrEmail (String username, String email);

    Optional<User> findByUsername (String username);

    Optional<User> findFirstByUsername(String username);

    Optional<User> findFirstByEmail(String email);

}