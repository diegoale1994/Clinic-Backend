package com.rexsoft.clinic.app.services;

import java.util.List;

import com.rexsoft.clinic.app.dto.ConsultaListaExamenDTO;
import com.rexsoft.clinic.app.dto.ConsultaResumenDTO;
import com.rexsoft.clinic.app.dto.FiltroConsultaDTO;
import com.rexsoft.clinic.app.models.Consulta;

public interface IConsultaService extends ICRUD<Consulta> {
	public Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO);
	public List<Consulta> buscar(FiltroConsultaDTO filtro);
	public List<Consulta> buscarfecha(FiltroConsultaDTO filtro);
	public List<ConsultaResumenDTO> listaResumen();
	public byte[] generarReporte();
}
