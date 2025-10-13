package com.cifp.Ejercicio3.models;

public class Animal {

    private int id;
    private String nombre;
    private int vidaMedia;
    private boolean esExtinto;

    public Animal() {};

    public Animal(int id, String nombre, int vidaMedia, boolean esExtinto) {
        setId(id);
        setNombre(nombre);
        setVidaMedia(vidaMedia);
        setEsExtinto(esExtinto);
    }

    public int getId() {
        return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getVidaMedia() {
        return this.vidaMedia;
    }
    public boolean getEsExtinto() {
        return this.esExtinto;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) throws IllegalArgumentException {
        nombre = nombre.trim();
        if (nombre.length() >= 3 && nombre.length() <= 15)
            this.nombre = nombre;
        else
            throw new IllegalArgumentException("El mínimo de carácteres debe ser 3 y el máximo 15.");
    }
    public void setVidaMedia(int vidaMedia) throws IllegalArgumentException {
        if (vidaMedia >= 0 && vidaMedia <= 600)
            this.vidaMedia = vidaMedia;
        else
            throw new IllegalArgumentException("La edad media debe estar entre 0 y 600");
    }
    public void setEsExtinto(boolean esExtinto) {
        this.esExtinto = esExtinto;
    }

}
