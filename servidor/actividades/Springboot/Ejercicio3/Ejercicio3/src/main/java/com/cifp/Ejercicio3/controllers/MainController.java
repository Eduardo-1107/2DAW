package com.cifp.Ejercicio3.controllers;
import com.cifp.Ejercicio3.services.AnimalService;
import com.cifp.Ejercicio3.models.Animal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animales")
public class MainController {
    @Autowired
    private AnimalService animalService;

    @GetMapping()
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
            return "redirect:/animales";
        }
    }
    @GetMapping("/detalles/{id}")
    public String mostrarAnimal(@PathVariable Integer id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "detalles";
    }
    @GetMapping("/editar/{id}")
    public String modificarAnimal(@PathVariable Integer id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "editar";
    }
    @PostMapping("/editar")
    public String modificarAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editar";
        } else {
            animalService.actualizarAnimal(animal);
            return "redirect:/animales";
        }
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Integer id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "eliminar";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Integer id) {
        animalService.eliminarAnimal(animalService.getAnimalById(id));
        return "redirect:/animales";
    }
}
