package com.rexsoft.clinic.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexsoft.clinic.app.models.Paciente;
import com.rexsoft.clinic.app.repos.IPacienteRepo;
import com.rexsoft.clinic.app.services.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepo pacienteRepo;
	
	@Override
	public Paciente registrar(Paciente t) {
		return pacienteRepo.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		return pacienteRepo.save(t);
	}

	@Override
	public Paciente leer(Integer id) {
		return pacienteRepo.findById(id).orElse(null);
	}

	@Override
	public List<Paciente> listartodos() {
		return pacienteRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		pacienteRepo.deleteById(id);
	}

}
