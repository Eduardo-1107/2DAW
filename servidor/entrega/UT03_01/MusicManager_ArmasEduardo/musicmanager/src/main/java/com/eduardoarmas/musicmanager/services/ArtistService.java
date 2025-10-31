package com.eduardoarmas.musicmanager.services;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    // CRUD

    //Read (todos)
    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    //Read (Uno solo)
    public Artist getArtistById(int id) {
        return artistRepository.findById(id).orElse(null);
    }

    //Read (Top 15 Ordenados por orden alfabético descendiente)
    public List<Artist> getArtistsFilter() {
        return artistRepository.findTop15ByOrderByNameDesc();
    }

    //Create y Update
    public void setArtist( Artist artist) {
        artistRepository.save(artist);
    }

    //Delete
    public void deleteArtist(Artist artist) {
        artistRepository.delete(artist);
    }

}
