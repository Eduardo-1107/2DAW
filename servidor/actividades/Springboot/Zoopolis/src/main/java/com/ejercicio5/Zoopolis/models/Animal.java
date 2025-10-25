package com.ejercicio5.Zoopolis.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;


@Entity
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

    public Animal() {};

    public Animal(Integer id, String nombre, Integer vidaMedia, boolean esExtinto) {
        setId(id);
        setNombre(nombre);
        setVidaMedia(vidaMedia);
        setEsExtinto(esExtinto);
    }
    public Animal(String nombre, Integer vidaMedia, boolean esExtinto) {
        setNombre(nombre);
        setVidaMedia(vidaMedia);
        setEsExtinto(esExtinto);
    }

    public Integer getId() {
        return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public Integer getVidaMedia() {
        return this.vidaMedia;
    }
    public boolean getEsExtinto() {
        return this.esExtinto;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre)  {
        this.nombre = nombre;
    }
    public void setVidaMedia(Integer vidaMedia)  {
        this.vidaMedia = vidaMedia;
    }
    public void setEsExtinto(boolean esExtinto) {
        this.esExtinto = esExtinto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return esExtinto == animal.esExtinto && Objects.equals(id, animal.id) && Objects.equals(nombre, animal.nombre) && Objects.equals(vidaMedia, animal.vidaMedia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, vidaMedia, esExtinto);
    }
}


