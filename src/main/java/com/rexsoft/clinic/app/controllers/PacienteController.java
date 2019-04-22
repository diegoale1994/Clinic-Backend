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

import com.rexsoft.clinic.app.models.Paciente;
import com.rexsoft.clinic.app.services.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService pacienteService;
	
	@GetMapping
	public List<Paciente> listar(){
		return pacienteService.listartodos();
	}
	
	@GetMapping("/{id}")
	public Paciente listarPorId(@PathVariable("id") Integer id) {
		return pacienteService.leer(id);
	}
	
	@PostMapping
	public Paciente registrar(@RequestBody Paciente paciente) {
		return pacienteService.registrar(paciente);
	}
	
	@PutMapping
	public Paciente actualizar(@RequestBody Paciente paciente) {
		return pacienteService.modificar(paciente);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		pacienteService.eliminar(id);
	}
}
