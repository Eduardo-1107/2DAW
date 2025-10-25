package com.ejercicio5.Zoopolis.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Clase {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size (min = 3, max = 15, message = "El nombre debe estar entre 3 y 15 caracteres")
    private String nombre;

    @OneToMany(
            mappedBy = "clase",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Animal> animales;



    public Clase() {}

    public Clase(Integer id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public Clase(String nombre) {
        setNombre(nombre);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }
}
