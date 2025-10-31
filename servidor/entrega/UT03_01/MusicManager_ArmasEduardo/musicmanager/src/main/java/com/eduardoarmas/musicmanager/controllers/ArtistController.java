package com.eduardoarmas.musicmanager.controllers;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.models.Artist;
import com.eduardoarmas.musicmanager.services.AlbumService;
import com.eduardoarmas.musicmanager.services.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;
    @Autowired
    private AlbumService albumService;

    // Listar los artistas
    @GetMapping()
    public String listsArtists(Model model) {
        model.addAttribute("artists", artistService.getArtistsFilter());
        return "artists/index";
    }
    // Crear nuevo Artista
    @GetMapping("/create")
    public String createArtist(Model model) {
        model.addAttribute("artist", new Artist());
        return "artists/create";
    }
    @PostMapping("/create")
    public String createArtist(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "artists/create";
        } else {
            artistService.setArtist(artist);
            return "redirect:/artists";
        }
    }
    // Detalles Artista
    @GetMapping("/details/{id}")
    public String detailsArtist(@PathVariable int id, Model model) {
        model.addAttribute("artist", artistService.getArtistById(id));
        return "artists/details";
    }
    // Editar Artista
    @GetMapping("edit/{id}")
    public String updateArtist(@PathVariable int id, Model model) {
        model.addAttribute("artist", artistService.getArtistById(id));
        return "artists/update";
    }
    @PostMapping("/edit")
    public String upgradeArtist(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "artists/edit";
        } else {
            artistService.setArtist(artist);
            return "redirect:/artists";
        }
    }
    // Borrar Artista
    @GetMapping("/delete/{id}")
    public String deleteArtists(@PathVariable int id, Model model) {
        model.addAttribute("artist", artistService.getArtistById(id));
        return "artists/delete";
    }
    @PostMapping("/delete/{id}")
    public String deleteArtist(@PathVariable int id) {
        artistService.deleteArtist(artistService.getArtistById(id));
        return "redirect:/artists";
    }
    //Detalles Discos por Artista
    @GetMapping("/artistAlbums/{id}")
    public String listAlbumsByArtist(@PathVariable int id,Model model) {
        model.addAttribute("albums", albumService.getAlbumByArtist(artistService.getArtistById(id)));
        return "artists/artistAlbums";
    }
}
