package com.cifp.Ejercicio3.models;

import jakarta.validation.constraints.*;

public class Animal {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 15, message = "La longitud debe de estar entre 3 y 15")
    private String nombre;

    @NotNull(message = "La edad media es obligatoria")
    @Min(value = 0, message = "La edad media no puede ser menor que 0")
    @Max(value = 600,message = "La edad no puede ser mayor que 600")
    private Integer vidaMedia;

    private boolean esExtinto;


    public Animal() {};

    public Animal(Integer id, String nombre, Integer vidaMedia, boolean esExtinto) {
        setId(id);
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
        //nombre = nombre.trim();
        //if (nombre.length() >= 3 && nombre.length() <= 15)
            this.nombre = nombre;
        //else
        //    throw new IllegalArgumentException("El mínimo de carácteres debe ser 3 y el máximo 15.");
    }
    public void setVidaMedia(Integer vidaMedia)  {
        //if (vidaMedia >= 0 && vidaMedia <= 600)
            this.vidaMedia = vidaMedia;
        //else
        //    throw new IllegalArgumentException("La edad media debe estar entre 0 y 600");
    }
    public void setEsExtinto(boolean esExtinto) {
        this.esExtinto = esExtinto;
    }

}
