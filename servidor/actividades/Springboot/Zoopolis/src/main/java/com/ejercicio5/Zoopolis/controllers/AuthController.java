package com.ejercicio5.Zoopolis.controllers;

import com.ejercicio5.Zoopolis.models.Animal;
import com.ejercicio5.Zoopolis.models.User;
import com.ejercicio5.Zoopolis.repositories.UserRepository;
import com.ejercicio5.Zoopolis.services.RoleService;
import com.ejercicio5.Zoopolis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.transform.Result;

@Controller
public class AuthController {
    @Autowired
    UserService userService;


    //Login

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    // Register

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        } else if (userService.findUserByEmail(user.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", null,"Este usuario ya está registrado.");
            return "register";
        } else {
                userService.setUser(user);
                return "redirect:/login";
        }
    }
}
