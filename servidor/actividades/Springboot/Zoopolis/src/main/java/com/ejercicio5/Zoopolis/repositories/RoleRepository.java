package com.ejercicio5.Zoopolis.repositories;

import com.ejercicio5.Zoopolis.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String name);
}