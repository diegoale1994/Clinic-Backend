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

import com.rexsoft.clinic.app.models.Examen;
import com.rexsoft.clinic.app.services.IExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private IExamenService examenService;

	@GetMapping
	public List<Examen> listar(){
		return examenService.listartodos();
	}
	
	@GetMapping("/{id}")
	public Examen listarPorId(@PathVariable("id") Integer id) {
		return examenService.leer(id);
	}
	
	@PostMapping
	public Examen registrar(@RequestBody Examen examen) {
		return examenService.registrar(examen);
	}
	
	@PutMapping
	public Examen actualizar(@RequestBody Examen examen) {
		return examenService.modificar(examen);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		examenService.eliminar(id);
	}
}
