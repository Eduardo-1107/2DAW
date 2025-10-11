package com.cifp.HolaMundo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class MainController {
    @GetMapping("/")
    public String saluda() {
        return "index";
    }
    @GetMapping("/despedida")
    public String despedida(Model model) {
        model.addAttribute("despedida","Adiós a todo el mundo");
        return "despedida";
    }
    @GetMapping({"/felicita/{id}","/felicita"})
    public String felicita(@PathVariable(required = false) String id, @RequestParam(defaultValue = "Amigo") String nombre, @RequestParam(defaultValue = "0") int edad, Model model ) {
        model.addAttribute("id", id);
        model.addAttribute("nombre", nombre);
        model.addAttribute("edad", edad);
        return "felicita";
    }
}