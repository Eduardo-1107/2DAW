package com.ejercicio5.Zoopolis.controllers;

import com.ejercicio5.Zoopolis.interfaces.IAnimalService;
import com.ejercicio5.Zoopolis.interfaces.IClaseService;
import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.models.Clase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clases")
public class ClaseController {
    @Autowired
    private IClaseService claseService;
    @Autowired
    IAnimalService animalService;

    @GetMapping()
    public String listadoClases(Model model) {
        model.addAttribute("clases", claseService.getClases());
        return "clases/index";
    }
    @GetMapping("/crear")
    public String crearClase(Model model) {
        model.addAttribute("clase", new Clase());
        return "clases/crear";
    }
    @PostMapping("/crear")
    public String crearClase(@Valid @ModelAttribute("clase") Clase clase, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clases/crear";
        } else {
            claseService.createClase(clase);
            return "redirect:/clases";
        }
    }
    @GetMapping("/detalles/{id}")
    public String mostrarClase(@PathVariable Integer id, Model model) {
        model.addAttribute("clase", claseService.getClaseById(id));
        model.addAttribute("animales", animalService.getAnimales());
        return "clases/detalles";
    }
    @GetMapping("/editar/{id}")
    public String modificarClase(@PathVariable Integer id, Model model) {
        model.addAttribute("clase", claseService.getClaseById(id));
        return "clases/editar";
    }
    @PostMapping("/editar")
    public String modificarClase(@Valid @ModelAttribute("clase") Clase clase, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "animales/editar";
        } else {
            claseService.updateClase(clase);
            return "redirect:/clases";
        }
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarClase(@PathVariable Integer id, Model model) {
        model.addAttribute("clase", claseService.getClaseById(id));
        return "clases/eliminar";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminarClases(@PathVariable Integer id) {
        claseService.deleteClase(claseService.getClaseById(id));
        return "redirect:/clases";
    }
}
