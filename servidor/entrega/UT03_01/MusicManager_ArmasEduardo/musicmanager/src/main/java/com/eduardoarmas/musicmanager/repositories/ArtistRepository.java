package com.eduardoarmas.musicmanager.repositories;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {
    List<Artist> findTop15ByOrderByNameDesc();

}
