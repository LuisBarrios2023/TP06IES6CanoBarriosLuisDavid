package ar.edu.ies6.controller;

import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.util.ListadoAlumnos;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


public class AlumnoController {


	@GetMapping({"/index", "/", "/home", "/alumno"})
	
	@PostMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
		ListadoAlumnos.getListado().add(alumno);
 	
        ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
		modelView.addObject("listado", ListadoAlumnos.getListado());
		
		return modelView;	
	}
}
