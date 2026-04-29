package com.krakedev.asistencias.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ServicioAsistencia {
	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
	private final ServicioEstudiantes servicioEstudiantes;

	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {
		//Buscar estudiante por cedula, en servicioEstudiantes
		// si no existe el estudiante retorna null
		//crea la asistencia, con la fecha y hora actuales
		 Asistencia asistencia = new Asistencia(LocalDate.now(),LocalDateTime.now(),"P");
		//crea un registro asistencia, agrega a la lista, retorna elregistro creado
		return null;
	}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		// retorna todas las asistencias del estudiante
		return null;
	}

}
