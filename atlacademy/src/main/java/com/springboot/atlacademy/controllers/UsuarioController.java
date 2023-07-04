package com.springboot.atlacademy.controllers;

import com.springboot.atlacademy.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable String id){
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre("Fabio");
        user.setApellido("Escobar");
        user.setEmail("fabioescobarardila@hotmail.com");
        user.setTelefono("3006336107");

        return user;
    }
}
