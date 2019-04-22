package com.rexsoft.clinic.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexsoft.clinic.app.models.Examen;
import com.rexsoft.clinic.app.repos.IExamenRepo;
import com.rexsoft.clinic.app.services.IExamenService;

@Service
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenRepo examenRepo;

	@Override
	public Examen registrar(Examen examen) {
		return examenRepo.save(examen);
	}

	@Override
	public Examen modificar(Examen examen) {
		return examenRepo.save(examen);
	}

	@Override
	public Examen leer(Integer id) {
		return examenRepo.findById(id).orElse(null);
	}

	@Override
	public List<Examen> listartodos() {
		return examenRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		examenRepo.deleteById(id);
	}
	
}
