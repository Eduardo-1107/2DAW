package com.ejercicio5.Zoopolis.repositories;
import com.ejercicio5.Zoopolis.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
