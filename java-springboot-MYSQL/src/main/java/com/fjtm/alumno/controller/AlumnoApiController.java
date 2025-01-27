package com.fjtm.alumno.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fjtm.alumno.repository.AlumnoRepository;
import com.fjtm.alumno.model.Alumno;

import java.util.List;

@RestController
@RequestMapping("/alumnos/api")
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde localhost:4200
public class AlumnoApiController {

    private final AlumnoRepository repository;

    public AlumnoApiController(AlumnoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Alumno> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Alumno findById(@PathVariable long id) {
        return repository.findById(id).orElse(null);  // Devuelve null si no existe el alumno
    }
}
