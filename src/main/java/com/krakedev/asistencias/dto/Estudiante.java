package com.krakedev.asistencias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // sonctructor con todos los atributos
@NoArgsConstructor // constructor vacio
public class Estudiante {
	//ATRIBUTOS
	private String cedula;
	private String nombre;
	private String apellido;

		
	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
}
