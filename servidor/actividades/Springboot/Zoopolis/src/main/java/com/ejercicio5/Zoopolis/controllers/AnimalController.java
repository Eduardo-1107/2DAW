package com.ejercicio5.Zoopolis.controllers;
import com.ejercicio5.Zoopolis.interfaces.IAnimalService;
import com.ejercicio5.Zoopolis.interfaces.IClaseService;
import com.ejercicio5.Zoopolis.models.Animal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/animales")
public class AnimalController {
    @Autowired
    private IAnimalService animalService;
    @Autowired
    private IClaseService claseService;

    @GetMapping()
    public String listadoAnimales(Model model) {
        model.addAttribute("animales", animalService.getAnimales());
        return "animales/index";
    }
    @GetMapping("/crear")
    public String crearAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("clases", claseService.getClases()) ;
        return "animales/crear";
    }
    @PostMapping("/crear")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "animales/crear";
        } else {
            animalService.createAnimal(animal);
            return "redirect:/animales";
        }
    }
    @GetMapping("/detalles/{id}")
    public String mostrarAnimal(@PathVariable Integer id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "animales/detalles";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar/{id}")
    public String modificarAnimal(@PathVariable Integer id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        model.addAttribute("clases", claseService.getClases());
        return "animales/editar";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/editar")
    public String modificarAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "animales/editar";
        } else {
            animalService.updateAnimal(animal);
            return "redirect:/animales";
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Integer id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "animales/eliminar";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Integer id) {
        animalService.deleteAnimal(animalService.getAnimalById(id));
        return "redirect:/animales";
    }
}


