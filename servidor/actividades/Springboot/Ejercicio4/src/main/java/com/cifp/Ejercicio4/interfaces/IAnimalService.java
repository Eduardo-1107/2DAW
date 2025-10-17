package com.cifp.Ejercicio4.interfaces;

import com.cifp.Ejercicio4.models.Animal;
import java.util.List;

public interface IAnimalService {
    List<Animal> getAnimales();
    Animal getAnimalById(Integer id);
    void createAnimal(Animal animal);
    void updateAnimal(Animal animal);
    void deleteAnimal(Animal animal);
}
