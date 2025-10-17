package com.cifp.Ejercicio4.repositories;

import com.cifp.Ejercicio4.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
