package com.eduardoarmas.musicmanager.services;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    // CRUD

    //Read (todos)
    public  List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    //Read (Uno solo)
    public Album getAlbumById(int id) {
        return albumRepository.findById(id).orElse(null);
    }

    //Read (Top 15 Ordenados por orden alfabético descendiente)
    public List<Album> getAlbumsFilter() {
        return albumRepository.findTop15ByOrderByTitleDesc();
    }
    //Read (Todos por Artista)
    public List<Album> getAlbumByArtist(Artist artist) {
        return  albumRepository.findAlbumByArtist(artist);
    }
    //Create y Update
    public void setAlbum(Album album) {
        albumRepository.save(album);
    }

    //Delete
    public void deleteAlbum(Album album) {
        albumRepository.delete(album);
    }
}
