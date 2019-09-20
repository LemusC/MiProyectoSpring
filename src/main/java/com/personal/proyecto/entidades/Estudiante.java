package com.personal.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
	
		@Id
		private int id;
		private String nombre;
		private String direccion;
		private int edad;
		
		public Estudiante() {
			
		}
		
		public Estudiante(int id, String nombre, String direccion, int edad) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.direccion = direccion;
			this.edad = edad;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		
}
