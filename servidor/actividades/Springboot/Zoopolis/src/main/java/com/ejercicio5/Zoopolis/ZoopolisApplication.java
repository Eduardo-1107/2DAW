package com.ejercicio5.Zoopolis;

import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.models.Clase;
import com.ejercicio5.Zoopolis.repositories.AnimalRepository;
import com.ejercicio5.Zoopolis.repositories.ClaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZoopolisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoopolisApplication.class, args);
	}
    @Bean
    CommandLineRunner seedDatabase(ClaseRepository claseRepository, AnimalRepository animalRepository) {
        return args -> {
            if (claseRepository.findAll().isEmpty()) {
                Clase c1 = new Clase("Mamífero");
                Clase c2 = new Clase("Ave");
                Clase c3 = new Clase("Reptil");

                c1 = claseRepository.save(c1);
                c2=  claseRepository.save(c2);
                c3 =claseRepository.save(c3);

                if (animalRepository.findAll().isEmpty()) {
                    Animal a1 = new Animal("Perro", 21, false, c1);
                    Animal a2 = new Animal("Gato", 18, false, c1);
                    Animal a3 = new Animal("Águila", 25, false, c2);
                    animalRepository.save(a1);
                    animalRepository.save(a2);
                    animalRepository.save(a3);
                }
            }
        };
    }
}
