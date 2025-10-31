package com.eduardoarmas.musicmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {
    // Atributos
    // Clave primaria
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // Generar ID automáticamente por JPA
    @Column(name = "AlbumId")
    private int albumId;

    @NotBlank(message = "El título no puede estar vacío") // Validaciones
    @Size(min = 3, max = 160, message = "El título debe estar entre 3 y 15 caracteres")
    @Column(name = "Title")
    private String title;

    @ManyToOne // Relación con Artista
    @JoinColumn(name = "ArtistId")
    private Artist artist;

    @OneToMany(mappedBy = "album",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Track> tracks = new ArrayList<>();
    // Constructores

    public Album() {} // Constructor vacío para JPA

    public Album(String Title, Artist artist, List<Track> tracks) { // Constructor completo
        setTitle(Title);
        setArtist(artist);
        setTracks(tracks);
    }

    //Getters y Setters


    public int getAlbumId() {
        return albumId;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public List<Track> getTracks() {
        return tracks;
    }


    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
