package com.rexsoft.clinic.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.rexsoft.clinic.app.models.ConsultaExamen;
import com.rexsoft.clinic.app.services.IConsultaExamenService;

@RestController
@RequestMapping("/consultaexamenes")
public class ConsultaExamenController {
	
	@Autowired
	private IConsultaExamenService ConsultaExamenService;
	
	@GetMapping(value = "/{idConsulta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConsultaExamen>> listar(@PathVariable("idConsulta") Integer idConsulta) {
		List<ConsultaExamen> consultaExamen = ConsultaExamenService.listarExamenesPorConsulta(idConsulta);
		return new ResponseEntity<List<ConsultaExamen>>(consultaExamen, HttpStatus.OK);
	}
}
