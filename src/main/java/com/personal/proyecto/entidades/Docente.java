package com.personal.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "docentes")
public class Docente {
	
	@Id
	private Integer id;
	private String nombre;
	private String especialidad;
	
	public Docente() {
		
	}

	public Docente(Integer id, String nombre, String especialidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
}
