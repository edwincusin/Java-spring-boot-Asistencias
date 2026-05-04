package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.dto.Estudiante;
import com.krakedev.asistencias.servicios.ServicioEstudiantes;

@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiantes {

	// Servicio inyectado por Spring (NO se instancia con new)
	private final ServicioEstudiantes servicioEstudiantes;
	
	// Constructor donde Spring inyecta la dependencia automáticamente
	public ControladorEstudiantes( ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}
	
	@PostMapping
	public void agregar(@RequestBody Estudiante estudiante) {
		servicioEstudiantes.agregar(estudiante);
	}
	
	@GetMapping("/{cedula}")
	public Estudiante buscarPorCedula(@PathVariable String cedula) {
		return servicioEstudiantes.buscarPorCedula(cedula);
	}
	
	@DeleteMapping("/{cedula}")
	public void eliminar(@PathVariable String cedula) {
		servicioEstudiantes.eliminar(cedula);
	}
	
	@PutMapping("/{cedula}")
	public void actualizar(@PathVariable String cedula, @RequestBody Estudiante estudiante) {
		servicioEstudiantes.actualizar(cedula, estudiante);
	}
	
	@GetMapping
	public ArrayList<Estudiante> listar(){
		return servicioEstudiantes.listar();
	}
}
