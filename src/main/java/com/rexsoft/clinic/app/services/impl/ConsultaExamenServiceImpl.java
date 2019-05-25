package com.rexsoft.clinic.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexsoft.clinic.app.models.ConsultaExamen;
import com.rexsoft.clinic.app.repos.IConsultaExamenRepo;
import com.rexsoft.clinic.app.services.IConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService {
	
	@Autowired
	private IConsultaExamenRepo consultaExamenRepo;
	
	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer id) {
		return consultaExamenRepo.listarExamenesPorConsulta(id);
	}
}
