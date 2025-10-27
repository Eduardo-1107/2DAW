package com.ejercicio5.Zoopolis.interfaces;

import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.models.Clase;

import java.util.List;

public interface IClaseService {
    List<Clase> getClases();
    Clase getClaseById(Integer id);
    void createClase(Clase clase);
    void updateClase(Clase clase);
    void deleteClase(Clase clase);
}
