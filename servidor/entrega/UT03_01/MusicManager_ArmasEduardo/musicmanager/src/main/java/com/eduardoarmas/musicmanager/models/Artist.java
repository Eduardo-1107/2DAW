package com.eduardoarmas.musicmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artist")
public class Artist {
    // Atributos
    // Clave Primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId")
    private int artistId;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 120, message = "El nombre debe estar entre 3 y 15 caracteres")
    @Column(name = "Name")
    private String name;

    @OneToMany( mappedBy = "artist",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                orphanRemoval = false)
    private List<Album> albums = new ArrayList<>();

    @OneToMany( mappedBy = "artist",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();


    // Constructores
    public Artist() {}

    public Artist(String name, List<Album> albums, List<Review> reviews) {
        setName(name);
        setAlbums(albums);
        setReviews(reviews);
    }

    //Getters y Setters

    public int getArtistId() {
        return artistId;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
