package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.dto.Asistencia;
import com.krakedev.asistencias.dto.Estudiante;
import com.krakedev.asistencias.dto.RegistroAsistencia;

@Service
public class ServicioAsistencia {
	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();

	private final ServicioEstudiantes servicioEstudiantes;// Servicio inyectado por Spring (no se instancia manualmente)

	// Constructor usado para la inyección de dependencias
	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}
	
	//METODO REGISTRAR ASISTENCIA : depende del metodo buscar cedula de la clase servicioEstudiantes
	public RegistroAsistencia registrarAsistencia(String cedula) {
		// Buscar estudiante por cedula, en servicioEstudiantes
		// si no existe el estudiante retorna null
		Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);
		
		if(estudiante!=null) {
			// crea la asistencia, con la fecha y hora actuales
			Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");
			// crea un registro asistencia, agrega a la lista, retorna elregistro creado
			RegistroAsistencia registroAsistencia = new RegistroAsistencia(estudiante, asistencia);
			registros.add(registroAsistencia);
			return registroAsistencia;
		}
		return null;
	}

	//METODO CONSULTAR ASISTENCIAS DE UN ESTUDIANTE
	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		// retorna todas las asistencias del estudiante
		ArrayList<Asistencia> asistencias=new ArrayList<Asistencia>();
		
		for(RegistroAsistencia registroA:registros) {
			if(registroA.getEstudiante().getCedula().equals(cedula)){
				Asistencia asistencia=registroA.getAsistencia();
				asistencias.add(asistencia);
			}
		}
		
		return asistencias;
	}

}
