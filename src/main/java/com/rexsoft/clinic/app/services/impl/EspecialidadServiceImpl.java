package com.rexsoft.clinic.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexsoft.clinic.app.models.Especialidad;
import com.rexsoft.clinic.app.repos.IEspecialidadRepo;
import com.rexsoft.clinic.app.services.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadRepo especialidadRepo;
	
	@Override
	public Especialidad registrar(Especialidad t) {
		return especialidadRepo.save(t);
	}

	@Override
	public Especialidad modificar(Especialidad t) {
		return especialidadRepo.save(t);
	}

	@Override
	public Especialidad leer(Integer id) {
		return especialidadRepo.findById(id).orElse(null);
	}

	@Override
	public List<Especialidad> listartodos() {
		return especialidadRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		especialidadRepo.deleteById(id);
	}

}
