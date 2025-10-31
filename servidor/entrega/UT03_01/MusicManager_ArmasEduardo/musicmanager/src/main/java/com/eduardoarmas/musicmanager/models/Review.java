package com.eduardoarmas.musicmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Review {

    // Atributos
    // Clave Primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 15, message = "El nombre debe estar entre 3 y 15 caracteres")
    private String title;

    @NotBlank( message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 30, message = "La descripción debe tener entre 5 y 30 carácteres")
    private String description;

    @NotNull(message = "La valoración no puede estar vacía")
    @Min(value = 1, message = "La valoración no puede ser inferior a 1")
    @Max(value = 5, message = "La valoración no puede ser superior a 5")
    private int rating;

    @ManyToOne
    private Artist artist;


    //Constructores

    public Review() {}

    public Review(String title, String description, int rating, Artist artist) {
        setArtist(artist);
        setTitle(title);
        setDescription(description);
        setRating(rating);
    }

    // Getters y Setters

    public int getReviewId() {
        return reviewId;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getDescription() {
        return description;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
