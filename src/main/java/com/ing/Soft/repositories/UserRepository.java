package com.ing.Soft.repositories;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);
    Optional<User> findByName(String name);
}
