package com.ejercicio5.Zoopolis.interfaces;
import com.ejercicio5.Zoopolis.models.Animal;
import java.util.List;

public interface IAnimalService {
    List<Animal> getAnimales();
    Animal getAnimalById(Integer id);
    void createAnimal(Animal animal);
    void updateAnimal(Animal animal);
    void deleteAnimal(Animal animal);
}