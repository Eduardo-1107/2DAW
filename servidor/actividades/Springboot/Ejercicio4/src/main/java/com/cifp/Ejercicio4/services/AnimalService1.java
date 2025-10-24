package com.cifp.Ejercicio4.services;

import com.cifp.Ejercicio4.interfaces.IAnimalService;
import com.cifp.Ejercicio4.models.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService1 implements IAnimalService {

    private int indexAnimal = 1;
    private List<Animal> animales = new ArrayList<>(Arrays.asList(new Animal(1,"Perro",21,false)));

    public  List<Animal> getAnimales() {
        return animales;
    }

    public Animal getAnimalById(Integer id) {

        for (Animal animal : animales) {
            if (animal.getId().equals(id))
                return animal;
        }
        return null;
    }

    public void createAnimal(Animal animal) {
        animal.setId(++indexAnimal);
        animales.add(animal);
    }

    public void updateAnimal(Animal animal) {
        for (Animal a : animales) {
            if (a.getId().equals(animal.getId())) {
                a.setNombre(animal.getNombre());
                a.setVidaMedia(animal.getVidaMedia());
                a.setEsExtinto(animal.getEsExtinto());
            }
        }
    }

    public void deleteAnimal(Animal animal) {
        animales.removeIf(a -> a.getId().equals(animal.getId()));
    }
}

