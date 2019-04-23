package com.rexsoft.clinic.app.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rexsoft.clinic.app.exception.ModeloNotFoundException;
import com.rexsoft.clinic.app.models.Paciente;
import com.rexsoft.clinic.app.services.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> pacientes = pacienteService.listartodos();
		return new ResponseEntity<List<Paciente>>(pacientes,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) {
		Paciente paciente = pacienteService.leer(id);
		if(paciente == null) {
			throw new ModeloNotFoundException(id + " no encontrado !");
		}
		return new ResponseEntity<Paciente>(paciente,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente paciente) {
		Paciente pac = pacienteService.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Paciente paciente) {
		pacienteService.modificar(paciente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		
		Paciente paciente = pacienteService.leer(id);
		if(paciente == null) {
			throw new ModeloNotFoundException(id + " no encontrado !");
		}else {
			pacienteService.eliminar(id);	
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
