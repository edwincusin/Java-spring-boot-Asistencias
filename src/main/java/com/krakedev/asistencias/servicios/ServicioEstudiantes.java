package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.dto.Estudiante;

@Service
public class ServicioEstudiantes {

	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	// no permite duplicados

	public void agregar(Estudiante estudiante) {
		if (buscarPorCedula(estudiante.getCedula()) == null) {
			estudiantes.add(estudiante);
		}

	}

//	public void agregar(Estudiante estudiante) {
//		boolean debeAgregar = true;
//		for (Estudiante e : estudiantes) {
//			if (e.getCedula().equals(estudiante.getCedula())) {
//				debeAgregar = false;
//				break;
//			}
//		}
//		if (debeAgregar) {
//			estudiantes.add(estudiante);
//		}
//		estudiantes.contains(estudiante);
//	}

	public Estudiante buscarPorCedula(String cedula) {
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getCedula().equals(cedula)) {
				return estudiante;
			}
		}
		return null;
	}

	public void eliminar(String cedula) {
		Estudiante estudiante = buscarPorCedula(cedula);
		if (estudiante != null) {
			estudiantes.remove(estudiante);
		}

	}

	public void actualizar(String cedula, Estudiante nuevo) {
		//opcion 1 : pero limitado solo para cuando se trata de pocos elementos seteando de uno en uno pero se puede obteniendo el index
		Estudiante estudiante = buscarPorCedula(cedula);
		if (estudiante != null) {
//			estudiante.setNombre(nuevo.getNombre());
//			estudiante.setApellido(nuevo.getApellido());
//			estudiante.setCedula(nuevo.getCedula());
			//obtengo el index del estudiante encontrado y lo seteo segun el index
			int index=estudiantes.indexOf(estudiante);
			estudiantes.set(index, nuevo);
		}

		//  opcion 2: redunda codigo
//		for (int i = 0; i < estudiantes.size(); i++) {
//			if (estudiantes.get(i).getCedula().equals(cedula)) {
//				estudiantes.set(i, nuevo);
//				break;
//			}
//		}
	}

	public ArrayList<Estudiante> listar() {
			return estudiantes;
	}

}
