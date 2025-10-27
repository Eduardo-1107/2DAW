package com.ejercicio5.Zoopolis.services;

import com.ejercicio5.Zoopolis.interfaces.IClaseService;
import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.models.Clase;
import com.ejercicio5.Zoopolis.repositories.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class ClaseServiceImp2 implements IClaseService {
    @Autowired
    ClaseRepository claseRepository;

    public List<Clase> getClases() {
        return claseRepository.findAll();
    }

    public Clase getClaseById(Integer id) {
        return claseRepository.findById(id).orElse(null);
    }

    public void createClase(Clase clase) {
        claseRepository.save(clase);
    }

    public void updateClase(Clase clase) {
        claseRepository.save(clase);
    }

    public void deleteClase(Clase clase) {
        claseRepository.delete(clase);
    }
}
