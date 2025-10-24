package com.cifp.Ejercicio4;

import com.cifp.Ejercicio4.models.Animal;
import com.cifp.Ejercicio4.repositories.IAnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio4Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio4Application.class, args);
	}

    @Bean
    CommandLineRunner SeedAnimal(IAnimalRepository animalRepository) {
        return (String[] args) -> {
            if(animalRepository.findAll().isEmpty()) {
                Animal a1 = new Animal("Perro", 21, false);
                animalRepository.save(a1);
            }
        };
    }
}
