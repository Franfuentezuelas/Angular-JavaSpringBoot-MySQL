package com.fjtm.alumno.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fjtm.alumno.repository.AlumnoRepository;

import com.fjtm.alumno.model.Alumno;


/*
 * CRUD
 * create
 * read/retrieve
 * update
 * delete
 */
@Controller

public class AlumnoController {
	// propiedad privada del objeto AlumnoController
	// es final para evitar errores y cambios erroneos
	private final AlumnoRepository repository;
	
	// constructor de la clase con el repositorio
	public AlumnoController(AlumnoRepository repository) {
		this.repository=repository;
	}
	
	// entrada de inicio al acceder 
	//http://localhost:9000
	@GetMapping("/")
	public String index() {
		return "redirect:/alumnos";
	}
	
	// entrada a la lista de alumnos
	//http://localhost:9000/alumnos
	@GetMapping("/alumnos")
	public String findAll(Model model) {
		// utilizando el repository obtenemos todos los alumnos
		model.addAttribute("alumnos", repository.findAll());
		// el metodo implementa la plantilla alumnos-list con la lista de alumnos
		return "alumno-list";
	}
	
	// entrada para ver un alumno
	// http://localhost:9000/alumnos/id
	@GetMapping("/alumnos/{id}")
	public String findById(Model model, @PathVariable long id) {
		// utilizando el repository obtenemos todos los alumnos
		model.addAttribute("alumno", repository.findById(id).get());
		// el metodo implementa la plantilla alumnos-list con la lista de alumnos
		return "alumno-view";
	}
	
	// entrada al formulario
	// http://localhost:9000/alumnos/form
	@GetMapping("/alumnos/form")
	public String getFormEmpty(Model model) {
		// no creo que necesite un alumno vacio pero por si acaso lugo lo valido en la plantilla
		model.addAttribute("alumno", new Alumno());
		return "alumno-form";
	}
	
	// entrada al formulario de un alumno
	// http://localhost:9000/alumnos/edit/id
	@GetMapping("/alumnos/edit/{id}")
	public String getFormEdit(Model model, @PathVariable long id) {
		if(repository.existsById(id)) {
			repository.findById(id).ifPresent(a -> model.addAttribute("alumno", a));
			return "alumno-form";
		}else {
			return "redirect:alumnos/form";
		}
	}
	
	// http://localhost:9000/alumnos pero por POST
	@PostMapping("/alumnos")
	public String create(@ModelAttribute Alumno alumno) {
		if(alumno.getId()!=null) {
			repository.findById(alumno.getId()).ifPresent(a ->{
				// actualizamos los campos que queramos del alumno
				a.setNombre(alumno.getNombre());
				a.setApellidos(alumno.getApellidos());
				a.setEdad(alumno.getEdad());
				a.setCurso(alumno.getCurso());
				a.setClase(alumno.getClase());
				a.setNotas(alumno.getNotas());	
				// solo se actualizara si se han realizado los cambios anteriores???
				repository.save(a);
			});
		}else {
			repository.save(alumno);
		}
		// independientemente de que se guarde o se modifique siempre volvemos a la lista de alumnos
		return "redirect:/alumnos";
	}
	
	// http://localhost:9000/alumnos/delete/id
	@GetMapping("/alumnos/delete/{id}")
	public String deleteById(@PathVariable long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
		return "redirect:/alumnos";
	}
	
}
