package com.App.crud.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/carreras")
public class CarreraAcademicaController {

    @GetMapping
    public String test() {
        return "API funcionando";
    }
}
