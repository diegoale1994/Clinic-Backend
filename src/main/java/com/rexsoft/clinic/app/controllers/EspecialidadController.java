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

import com.rexsoft.clinic.app.models.Especialidad;
import com.rexsoft.clinic.app.services.IEspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService especialidadService;
	
	@GetMapping
	public List<Especialidad> listar(){
		return especialidadService.listartodos();
	}
	
	@GetMapping("/{id}")
	public Especialidad listarPorId(@PathVariable("id") Integer id) {
		return especialidadService.leer(id);
	}
	
	@PostMapping
	public Especialidad registrar(@RequestBody Especialidad especialidad) {
		return especialidadService.registrar(especialidad);
	}
	
	@PutMapping
	public Especialidad actualizar(@RequestBody Especialidad especialidad) {
		return especialidadService.modificar(especialidad);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		especialidadService.eliminar(id);
	}
}
