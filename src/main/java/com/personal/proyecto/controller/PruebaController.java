package com.personal.proyecto.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("prueba")
public class PruebaController {

	@RequestMapping("guardar") // nombre de url
	public String guardar() {
		return "add"; // nombre de la vista
	}

	@GetMapping("vista1")
	public String otraVista(Model m) {

		// mandando parametros a la vista con el objeto de tipo model
		String v = "Soy otro parametro desde un controlador";
		m.addAttribute("v", v);
		m.addAttribute("parametro", "Soy un parametro desde un controlador");

		return "view";
	}

	// RUTA PARA MOSTRAR LA VISTA DE OPERACIONES
	@GetMapping("vista")
	public String mostrarValores() {
		return "vista";
	}

	// RUTA PARA PROCESAR LA OPERACION
	@PostMapping("vista")
	public String procesarOperacion(Model m, HttpServletRequest request) {
		// recibimos datos de la peticion
		Double n1 = Double.parseDouble(request.getParameter("n1"));
		Double n2 = Double.parseDouble(request.getParameter("n2"));

		m.addAttribute("resultado", (n1 + n2));
		return "Vista";
	}

	// ----------------------------------------------------------------------------

	@GetMapping("Operaciones")
	public String peticionValores() {

		return "vistaOperaciones";
	}

	@PostMapping("Operaciones")
	public String procesamiento(Model m, HttpServletRequest request) {
		String operador = request.getParameter("operador");
		Double n1 = Double.parseDouble(request.getParameter("n1"));
		Double n2 = Double.parseDouble(request.getParameter("n2"));

		if (operador.equalsIgnoreCase("suma")) {
			m.addAttribute("resultado", (n1 + n2));
		} else if (operador.equalsIgnoreCase("resta")) {
			if (n1 > n2) {
				m.addAttribute("resultado", (n1 - n2));
			} else {
				m.addAttribute("resultado", "El segundo numero no puede ser mayor al primero");
			}
		} else if (operador.equalsIgnoreCase("multiplicacion")) {
			m.addAttribute("resultado", (n1*n2));
		} else if (operador.equalsIgnoreCase("division")) {
			m.addAttribute("resultado", (n1/n2));
		}
		return "vistaOperaciones";
	}
	
	@RequestMapping("suma/{n1}/{n2}")
	public ModelAndView suma(
			@PathVariable(value = "n1") Double n1,
			@PathVariable(value = "n2") Double n2,
			Model m){
		
		//objeto para manipular la vista a retornar
		//y lo que se le pasara como modelo de datos
		ModelAndView mv = new ModelAndView();
		mv.setViewName("vistaOperaciones");
		m.addAttribute("r", (n1+n2));
		
		return mv;
	}
	
	
	
	
	

}





















