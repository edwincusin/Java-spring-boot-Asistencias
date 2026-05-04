package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.dto.Asistencia;
import com.krakedev.asistencias.dto.RegistroAsistencia;
import com.krakedev.asistencias.servicios.ServicioAsistencia;

@RestController
@RequestMapping("/asistencia")
public class ControladorAsistencia {
	// Servicio inyectado por Spring (no usar new)
	private final ServicioAsistencia servicioAsistencia;
	// Constructor para inyección de dependencias
	public ControladorAsistencia(ServicioAsistencia servicioAsistencia) {
		this.servicioAsistencia=servicioAsistencia;
	}
	
	// ENDPOINTS	
	@PostMapping("/{cedula}")
	public RegistroAsistencia registrarAsistencia(@PathVariable String cedula) {
		return servicioAsistencia.registrarAsistencia(cedula);
	}
	
	@GetMapping("/{cedula}")
	public ArrayList<Asistencia> consultarAsistencia(@PathVariable String cedula){
		return servicioAsistencia.consultarAsistencia(cedula);
	}
	
}
