package com.eduardoarmas.musicmanager.repositories;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,Integer> {
    List<Track> findByAlbum(Album album);
}
