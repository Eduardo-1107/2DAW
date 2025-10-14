package com.cifp.Ejercicio3.controllers;
import com.cifp.Ejercicio3.services.AnimalService;
import com.cifp.Ejercicio3.models.Animal;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    AnimalService animalService;

    public MainController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/")
    public String listadoAnimales(Model model) {
        model.addAttribute("animales", animalService.obtenerAnimales());
        return "index";
    }
    @GetMapping("/crear")
    public String crearAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "crear";
    }
    @PostMapping("/crear")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "crear";
        } else {
            animalService.crearAnimal(animal);
            return "redirect:/";
        }
    }
}
