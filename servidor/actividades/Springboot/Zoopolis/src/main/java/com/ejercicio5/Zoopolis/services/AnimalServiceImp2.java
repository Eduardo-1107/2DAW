package com.ejercicio5.Zoopolis.services;


import com.ejercicio5.Zoopolis.interfaces.IAnimalService;
import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class AnimalServiceImp2 implements IAnimalService {

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

