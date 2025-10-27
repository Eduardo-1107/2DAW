package com.ejercicio5.Zoopolis.services;

import com.ejercicio5.Zoopolis.interfaces.IClaseService;
import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.models.Clase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClaseServiceImp1 implements IClaseService {
    private int indexClase = 1;
    private List<Animal> animales = new ArrayList<>();
    private List<Clase> clases = new ArrayList<>(Arrays.asList(new Clase(1,"Mamifero", animales), new Clase(2,"Ave", animales), new Clase(3, "Reptil", animales)));
    public  List<Clase> getClases() {
        return clases;
    }

    public Clase getClaseById(Integer id) {

        for (Clase clase : clases) {
            if (clase.getId().equals(id))
                return clase;
        }
        return null;
    }

    public void createClase(Clase clase) {
        clase.setId(++indexClase);
        clases.add(clase);
    }

    public void updateClase(Clase clase) {
        for (Clase a : clases) {
            if (a.getId().equals(clase.getId())) {
                a.setNombre(clase.getNombre());
            }
        }
    }

    public void deleteClase(Clase clase) {
        clases.removeIf(a -> a.getId().equals(clase.getId()));
    }
}
