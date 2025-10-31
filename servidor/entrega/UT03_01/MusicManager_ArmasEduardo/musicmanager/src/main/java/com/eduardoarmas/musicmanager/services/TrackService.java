package com.eduardoarmas.musicmanager.services;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.models.Track;
import com.eduardoarmas.musicmanager.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    @Autowired
    TrackRepository trackRepository;

    // CRUD

    //Read (todos)
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    // Read (todas las canciones por album)
    public List<Track> getTracksByAlbum(Album album) {
        return trackRepository.findByAlbum(album);
    }

}
