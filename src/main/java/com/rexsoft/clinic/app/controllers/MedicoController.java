package com.rexsoft.clinic.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rexsoft.clinic.app.models.Medico;

import com.rexsoft.clinic.app.services.IMedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private IMedicoService medicoService;

	@GetMapping
	public List<Medico> listar(){
		return medicoService.listartodos();
	}
	
	@GetMapping("/{id}")
	public Medico listarPorId(@PathVariable("id") Integer id) {
		return medicoService.leer(id);
	}
	
	@PostMapping
	public Medico registrar(@RequestBody Medico medico) {
		return medicoService.registrar(medico);
	}
	
	@PutMapping
	public Medico actualizar(@RequestBody Medico medico) {
		return medicoService.modificar(medico);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		medicoService.eliminar(id);
	}
}
