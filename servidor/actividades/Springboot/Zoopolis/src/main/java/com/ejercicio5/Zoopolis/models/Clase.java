package com.ejercicio5.Zoopolis.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Clase {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;


    @NotBlank(message = "El nombre es obligatorio")
    @Size (min = 3, max = 15, message = "El nombre debe estar entre 3 y 15 caracteres")
    private String nombre;


    @OneToMany(
            mappedBy = "clase",
            cascade = CascadeType.ALL)
    private List<Animal> animales = new ArrayList<>();


    public Clase(String nombre) {
        setNombre(nombre);
    }

}
