package com.personal.proyecto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.personal.proyecto.data.Data;
import com.personal.proyecto.entidades.Estudiante;
import com.personal.proyecto.repositorio.IEstudianteRepository;

@Controller
@RequestMapping("student")
public class EstudianteController {
	
	@Autowired
	IEstudianteRepository er;
	
	/*public EstudianteController() {
		Data.listadoEstudiantes.add(new Estudiante(01, "Carlos", "Santa Ana", 24));
		Data.listadoEstudiantes.add(new Estudiante(02, "Jefferson", "San Salvador", 15));
		Data.listadoEstudiantes.add(new Estudiante(03, "Cristian", "Santa Tecla", 23));
	}*/
	
	//agregando datos por defecto al listado 
	
	@GetMapping("index")
	public String listar(Model m) {
		m.addAttribute("items", (List<Estudiante>) er.findAll());
		return "estudiante/listarEstudiante";
	}
	
	@GetMapping("add")
	public String vistaGuardar(){
		return "estudiante/guardarEstudiante";
	}
	
	@PostMapping("add")
	public String guardar(@RequestParam Integer id,
			@RequestParam String nombre,
			@RequestParam String direccion,
			@RequestParam Integer edad) {
		
		//procesando peticion
		Estudiante e = new Estudiante(id, nombre, direccion, edad);
		
		er.save(e);
		
		//Data.listadoEstudiantes.add(e);
		
		return "redirect:/student/index";
	}
}
