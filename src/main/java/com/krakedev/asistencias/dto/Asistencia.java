package com.krakedev.asistencias.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // sonctructor con todos los atributos
@NoArgsConstructor // constructor vacio
public class Asistencia {
	private LocalDate fechaClase;
	private LocalDateTime fechaHoraRegistro;
	private String estado; // P-Presente A-Ausent

	@Override
	public String toString() {
		return "Asistencia [fechaClase=" + fechaClase + ", fechaHoraRegistro=" + fechaHoraRegistro + ", estado="
				+ estado + "]";
	}

}
