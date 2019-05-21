package com.rexsoft.clinic.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rexsoft.clinic.app.models.Paciente;

public interface IPacienteService extends ICRUD<Paciente>{
	Page<Paciente> listarPageable(Pageable page);
}
