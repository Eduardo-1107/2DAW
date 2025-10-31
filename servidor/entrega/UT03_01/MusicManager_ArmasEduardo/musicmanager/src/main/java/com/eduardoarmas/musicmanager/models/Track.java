package com.eduardoarmas.musicmanager.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "track")
public class Track {

    // Atributos
    // Clave Primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrackId")
    private int trackId;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 200, message = "El nombre contener entre 3 y 15 carácteres")
    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AlbumId")
    private Album album;

    // Constructores

    public Track() {}

    public Track(String name, Album album) {
        setName(name);
        setAlbum(album);
    }

    // Getters y Setters


    public String getName() {
        return name;
    }

    public int getTrackId() {
        return trackId;
    }

    public Album getAlbum() {
        return album;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }
}
