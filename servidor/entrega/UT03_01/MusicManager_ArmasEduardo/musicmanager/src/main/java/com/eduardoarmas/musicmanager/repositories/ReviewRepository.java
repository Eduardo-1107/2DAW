package com.eduardoarmas.musicmanager.repositories;

import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findByArtist(Artist artist);
}
