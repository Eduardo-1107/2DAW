package com.eduardoarmas.musicmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    // Controlador para ver vista Principal
    @GetMapping()
    public String mainPage() {
        return "home";
    }

    //Ver Login
    @GetMapping("/login")
    public String lookLogin() {
        return "login";
    }
}
