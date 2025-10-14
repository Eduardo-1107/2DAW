package com.cifp.Ejercicio3.services;

import com.cifp.Ejercicio3.models.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private int indexAnimal = 0;
    private List<Animal> animales = new ArrayList<>();

    public  List<Animal> obtenerAnimales() {
        return animales;
    }

    public void crearAnimal(Animal animal) {
        animal.setId(++indexAnimal);
        animales.add(animal);
    }

}
