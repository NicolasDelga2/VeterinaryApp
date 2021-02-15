package com.vetApplication.program.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pet")
public class PetController {

    @GetMapping("/getPets")
    public String getPets(){
        return "Falta trabajar con Pets";
    }
}
