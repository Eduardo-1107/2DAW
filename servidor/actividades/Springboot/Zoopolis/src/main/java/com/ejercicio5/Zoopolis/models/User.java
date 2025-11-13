package com.ejercicio5.Zoopolis.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "No poner tu nombre")
    @Size(min = 3, max = 60, message = "Debe de estar en 3 y 10 carácteres")
    private String  username;

    @NotBlank(message = "Debes poner tus apellidos")
    @Size(min = 3, max = 60, message = "Tus apellidos deben de estar entre 3 y 30 carácteres")
    private String surname;

    @NotBlank
    @Size(min = 5, max = 80, message = "El email debe de estar entre 5 y 20 carácteres")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Debes poner una contraseña")
    @Size(min = 4, message = "Debes poner 4 carácteres")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    public User(String password, String email, String surname, String username) {
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.username = username;
    }
}
