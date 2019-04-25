package com.rexsoft.clinic.app.services;

import com.rexsoft.clinic.app.dto.ConsultaListaExamenDTO;
import com.rexsoft.clinic.app.models.Consulta;

public interface IConsultaService extends ICRUD<Consulta> {
	public Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO);
}
