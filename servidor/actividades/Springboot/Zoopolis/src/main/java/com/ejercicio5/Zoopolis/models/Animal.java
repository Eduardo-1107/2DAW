package com.ejercicio5.Zoopolis.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 15, message = "La longitud debe de estar entre 3 y 15")
    private String nombre;

    @NotNull(message = "La edad media es obligatoria")
    @Min(value = 0, message = "La edad media no puede ser menor que 0")
    @Max(value = 600,message = "La edad no puede ser mayor que 600")
    private Integer vidaMedia;

    private boolean esExtinto;

    @ManyToOne
    private Clase clase;

    public Animal(String nombre, Integer vidaMedia, boolean esExtinto, Clase clase) {
        this.nombre = nombre;
        this.vidaMedia = vidaMedia;
        this.esExtinto = esExtinto;
        this.clase  = clase;
    }


}


