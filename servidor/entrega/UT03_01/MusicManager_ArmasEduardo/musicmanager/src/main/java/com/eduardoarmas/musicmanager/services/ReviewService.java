package com.eduardoarmas.musicmanager.services;

import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.models.Review;
import com.eduardoarmas.musicmanager.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    // CRUD

    //Read (todos por artistas)
    public List<Review> getReviewByArtist(Artist artist) {
        return reviewRepository.findByArtist(artist);
    }

    //Create
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

}
