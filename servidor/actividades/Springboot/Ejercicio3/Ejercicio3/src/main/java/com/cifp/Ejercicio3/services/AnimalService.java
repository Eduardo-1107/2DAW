package com.cifp.Ejercicio3.services;

import com.cifp.Ejercicio3.models.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService {

    private int indexAnimal = 1;
    private ArrayList<Animal> animales = new ArrayList<>(Arrays.asList(new Animal(1,"Perro",21,false)));

    public  ArrayList<Animal> obtenerAnimales() {
        return animales;
    }

    public Animal getAnimalById(Integer id) {
        for (Animal animal : animales) {
            if (animal.getId().equals(id))
                return animal;
        }
        return null;
    }

    public void crearAnimal(Animal animal) {
        animal.setId(++indexAnimal);
        animales.add(animal);
    }

}
