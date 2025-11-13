package com.ejercicio5.Zoopolis.repositories;

import com.ejercicio5.Zoopolis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
}
