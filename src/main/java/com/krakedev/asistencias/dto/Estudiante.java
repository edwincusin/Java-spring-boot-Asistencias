package com.krakedev.asistencias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
