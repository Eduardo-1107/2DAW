package com.cifp.HolaMundo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

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
            ArrayList<String> felicitaciones = new ArrayList<>();
            model.addAttribute("edad" ,edad);
            model.addAttribute("msg", "Hoy el usuario con ID: " + id + " cumple " + edad + " años.");

            for (int i = 0; i < edad; i++)
                felicitaciones.add("Felicidades " + nombre);

            model.addAttribute("felicitaciones", felicitaciones);

            return "felicita";
        }
    }