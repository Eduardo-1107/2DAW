package com.cifp.Ejercicio4.services;

import com.cifp.Ejercicio4.interfaces.IAnimalService;
import com.cifp.Ejercicio4.models.Animal;
import com.cifp.Ejercicio4.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class AnimalService2 implements IAnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> getAnimales() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Integer id) {
        return animalRepository.findById(id).orElse(null);
    }

    public void createAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(Animal animal) {
        animalRepository.delete(animal);
    }
}
