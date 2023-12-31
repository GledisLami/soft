package com.ing.Soft.repositories;

import com.ing.Soft.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);
    Optional<User> findByName(String name);

    @Query(value = "SELECT id from user WHERE username=:username", nativeQuery = true)
    Integer getIdByUsername(String username);
}
