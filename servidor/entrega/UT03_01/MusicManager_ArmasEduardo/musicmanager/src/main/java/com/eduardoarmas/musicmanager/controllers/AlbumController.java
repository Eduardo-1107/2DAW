package com.eduardoarmas.musicmanager.controllers;

import com.eduardoarmas.musicmanager.models.Album;
import com.eduardoarmas.musicmanager.services.AlbumService;
import com.eduardoarmas.musicmanager.services.ArtistService;
import com.eduardoarmas.musicmanager.services.TrackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private TrackService trackService;
    @Autowired
    private ArtistService artistService;

    // Listar los discos
    @GetMapping()
    public String listsAlbums(Model model) {
        model.addAttribute("albums", albumService.getAlbumsFilter());
        return "albums/index";
    }
    // Crear nuevo disco
    @GetMapping("/create")
    public String createAlbum(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("artists", artistService.getArtists());
        return "/albums/create";
    }
    @PostMapping("/create")
    public String createAlbum(@Valid @ModelAttribute("album") Album album, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "albums/create";
        } else {
            albumService.setAlbum(album);
            return "redirect:/albums";
        }
    }
    // Detalles Disco
    @GetMapping("/details/{id}")
    public String detailsAlbum(@PathVariable int id, Model model) {
        model.addAttribute("album", albumService.getAlbumById(id));
//        model.addAttribute("tracks", trackService.getTracksByAlbum(albumService.getAlbumById(id)));
        return "albums/details";
    }
    // Editar Disco
    @GetMapping("/edit/{id}")
    public String updateAlbum(@PathVariable int id, Model model) {
        model.addAttribute("album", albumService.getAlbumById(id));
        model.addAttribute("artists", artistService.getArtists());
        return "albums/update";
    }
    @PostMapping("/edit")
    public String updateAlbum(@Valid @ModelAttribute("album") Album album, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "albums/edit";
        } else {
            albumService.setAlbum(album);
            return "redirect:/albums";
        }
    }
    // Borrar Disco
    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable int id, Model model) {
        model.addAttribute("album", albumService.getAlbumById(id));
        return "albums/delete";
    }
    @PostMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable int id) {
        albumService.deleteAlbum(albumService.getAlbumById(id));
        return "redirect:/albums";
    }
}
