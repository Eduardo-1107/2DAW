package com.ejercicio5.Zoopolis.repositories;

import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.models.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {

}