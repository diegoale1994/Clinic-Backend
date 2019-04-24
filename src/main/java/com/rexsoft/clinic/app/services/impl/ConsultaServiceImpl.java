package com.rexsoft.clinic.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexsoft.clinic.app.models.Consulta;
import com.rexsoft.clinic.app.repos.IConsultaRepo;
import com.rexsoft.clinic.app.services.IConsultaService;


@Service
public class ConsultaServiceImpl implements IConsultaService {

	@Autowired
	private IConsultaRepo consultaRepo;
	
	@Override
	public Consulta registrar(Consulta cons) {
		cons.getDetalleConsulta().forEach(det -> det.setConsulta(cons));
		return consultaRepo.save(cons);
	}

	@Override
	public Consulta modificar(Consulta t) {
		return consultaRepo.save(t);
	}

	@Override
	public Consulta leer(Integer id) {
		return consultaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Consulta> listartodos() {
		return consultaRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		consultaRepo.deleteById(id);
	}

}
