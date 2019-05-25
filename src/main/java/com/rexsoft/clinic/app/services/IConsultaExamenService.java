package com.rexsoft.clinic.app.services;

import java.util.List;

import com.rexsoft.clinic.app.models.ConsultaExamen;

public interface IConsultaExamenService {
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer id);
}
