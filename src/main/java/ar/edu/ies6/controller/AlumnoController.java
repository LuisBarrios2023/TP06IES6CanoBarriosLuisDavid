package ar.edu.ies6.controller;

import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.service.AlumnoService;
import ar.edu.ies6.util.ListadoAlumnos;
import ch.qos.logback.core.model.Model;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlumnoController {
	@Autowired
	Alumno alu;
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping({"/index"})
	public String index(Model model) {
		return "index";
	}

	@GetMapping({"/alumno"})
	public ModelAndView cargarAlumno() {
		
		//Alumno alu = new Alumno ();
			
	//	alu.setFechaNac(LocalDate.of(1970, 1, 12));
	//	System.out.println("Edad: "+alu.calcularEdad());
		
		ModelAndView modelView = new ModelAndView ("alumno");
		modelView.addObject("alumno", alu);
		
		return modelView;	
	}
	
	@PostMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
		//ListadoAlumnos.getListado().add(alumno);
		alumnoService.guardarAlumno(alumno);
        ModelAndView modelView = new ModelAndView ("listadoAlumnos");
        modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		//modelView.addObject("listado", ListadoAlumnos.getListado());
		
		return modelView;	
	}
//	@PostMapping("/borrarAlumno/{dni}")
//	public ModelAndView eliminarAlumno(@PathVariable("dni") String dni) {
	    
//	    ListadoAlumnos.getListado().removeIf(alumno -> alumno.getDni().equals(dni));

//	    ModelAndView modelView = new ModelAndView("listadoAlumnos");
//	    modelView.addObject("listado", ListadoAlumnos.getListado());

//	    return modelView;
//	}
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception {
		
		ModelAndView modificaAlumno = new ModelAndView("alumno");
		modificaAlumno.addObject("alumno", alumnoService.encontrarUnAlumno(dni));
		
		return  modificaAlumno;	
	}
	@GetMapping("/borrarAlumno/{dni}")
	public String eliminarAlumno(@PathVariable Integer dni) throws Exception {
		alumnoService.eliminarAlumno(dni);
		
		return "redirect:/mostrarListado";	
	}
	@GetMapping("/mostrarListado")
	public ModelAndView mostrarAlumnos(){

		ModelAndView listado = new ModelAndView("listadoAlumnos");
		listado.addObject("listado", alumnoService.buscarTodosAlumnos());
		
		return listado;	
	}
}