package com.personal.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.personal.proyecto.entidades.Docente;
import com.personal.proyecto.repositorio.IDocenteRepository;

@Controller
@RequestMapping("teacher")
public class DocenteController {
	
	@Autowired
	IDocenteRepository dr;
	
	@GetMapping("index")
	public String listar(Model m) {
		m.addAttribute("items", (List<Docente>) dr.findAll());
		return "docente/listarDocente" ;
	}
	
	@GetMapping("add")
	public String vistaGuardar() {
		return "docente/guardarDocente";
	}
	
	@PostMapping("add")
	public String guardar(@RequestParam Integer id,
			@RequestParam String nombre,
			@RequestParam String especialidad) {
		Docente d = new Docente(id, nombre, especialidad);
		
		dr.save(d);
		
		return "redirect:/teacher/index";
	}
}
