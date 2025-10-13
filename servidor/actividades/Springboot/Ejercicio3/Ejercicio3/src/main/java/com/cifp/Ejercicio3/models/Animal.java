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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVidaMedia(int vidaMedia) {
        this.vidaMedia = vidaMedia;
    }
    public void setEsExtinto(boolean esExtinto) {
        this.esExtinto = esExtinto;
    }

}
