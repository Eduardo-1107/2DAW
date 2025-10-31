package com.eduardoarmas.musicmanager;

import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.models.Review;
import com.eduardoarmas.musicmanager.repositories.AlbumRepository;
import com.eduardoarmas.musicmanager.repositories.ArtistRepository;
import com.eduardoarmas.musicmanager.repositories.ReviewRepository;
import com.eduardoarmas.musicmanager.services.AlbumService;
import com.eduardoarmas.musicmanager.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MusicmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicmanagerApplication.class, args);
	}


    @Bean
    CommandLineRunner seedDatabase(ReviewRepository reviewRepository, ArtistRepository artistRepository, AlbumService albumService, ArtistService artistService) {
        return args -> {
            if (reviewRepository.findAll().isEmpty()) {

                Artist a1 = artistService.getArtistById(155);

                Review r1 = new Review("Genial", "El mejor artista del año", 5, a1);
                Review r2 = new Review("Regular", "Está muy sobrevalorado", 3, a1);
                Review r3 = new Review("Fatal", "Cada vez que canta se pone a llover", 1, a1);

                reviewRepository.save(r1);
                reviewRepository.save(r2);
                reviewRepository.save(r3);
            }
        };
    }
}
