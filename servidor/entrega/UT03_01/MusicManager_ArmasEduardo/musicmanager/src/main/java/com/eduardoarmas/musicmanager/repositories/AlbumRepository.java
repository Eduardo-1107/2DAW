package com.eduardoarmas.musicmanager.repositories;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
    List<Album> findTop15ByOrderByTitleDesc();
    List<Album> findAlbumByArtist(Artist artist);
}
