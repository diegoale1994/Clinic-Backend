package com.rexsoft.clinic.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rexsoft.clinic.app.dto.ConsultaListaExamenDTO;
import com.rexsoft.clinic.app.dto.ConsultaResumenDTO;
import com.rexsoft.clinic.app.dto.FiltroConsultaDTO;
import com.rexsoft.clinic.app.models.Consulta;
import com.rexsoft.clinic.app.repos.IConsultaExamenRepo;
import com.rexsoft.clinic.app.repos.IConsultaRepo;
import com.rexsoft.clinic.app.services.IConsultaService;


@Service
public class ConsultaServiceImpl implements IConsultaService {

	@Autowired
	private IConsultaRepo consultaRepo;
	
	@Autowired
	private IConsultaExamenRepo consultaExamenRepo;
	
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

	@Override
	@Transactional
	public Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO) {
		consultaDTO.getConsulta().getDetalleConsulta().forEach(det -> det.setConsulta(consultaDTO.getConsulta()));
		consultaRepo.save(consultaDTO.getConsulta());
		consultaDTO.getListExamen().forEach( e -> consultaExamenRepo.registrar(consultaDTO.getConsulta().getIdConsulta(), e.getIdExamen()));
		return consultaDTO.getConsulta();
	}

	@Override
	public List<Consulta> buscar(FiltroConsultaDTO filtro) {
		return consultaRepo.buscar(filtro.getDni(), filtro.getNombreCompleto());
	}

	@Override
	public List<Consulta> buscarfecha(FiltroConsultaDTO filtro) {
		return consultaRepo.buscarFecha(filtro.getFechaConsulta(), filtro.getFechaConsulta().plusDays(1));
	}

	@Override
	public List<ConsultaResumenDTO> listaResumen() {
		List<ConsultaResumenDTO> consulta = new ArrayList<>();
		consultaRepo.listarResumen().forEach(x -> {
			ConsultaResumenDTO cr = new ConsultaResumenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consulta.add(cr);
		});
		return consulta;
	}

}
