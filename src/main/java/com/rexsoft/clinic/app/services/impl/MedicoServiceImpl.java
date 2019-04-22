package com.rexsoft.clinic.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexsoft.clinic.app.models.Medico;
import com.rexsoft.clinic.app.repos.IMedicoRepo;
import com.rexsoft.clinic.app.services.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoRepo medicoRepo;
	
	@Override
	public Medico registrar(Medico medico) {
		return medicoRepo.save(medico);
	}

	@Override
	public Medico modificar(Medico medico) {
		return medicoRepo.save(medico);
	}

	@Override
	public Medico leer(Integer id) {
		return medicoRepo.findById(id).orElse(null);
	}

	@Override
	public List<Medico> listartodos() {
		return medicoRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		medicoRepo.deleteById(id);
	}

}
