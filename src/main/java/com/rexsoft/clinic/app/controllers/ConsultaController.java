package com.rexsoft.clinic.app.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
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
import com.rexsoft.clinic.app.models.Consulta;
import com.rexsoft.clinic.app.services.IConsultaService;



@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> listar(){
		List<Consulta> consultas = consultaService.listartodos();
		return new ResponseEntity<List<Consulta>>(consultas,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Resource<Consulta> listarPorId(@PathVariable("id") Integer id) {
		Consulta consulta = consultaService.leer(id);
		if(consulta == null) {
			throw new ModeloNotFoundException(id + " no encontrado !");
		}
		//Level 3 
		Resource <Consulta> resource = new Resource<Consulta>(consulta);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("consulta-resource"));
		return resource;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Consulta consulta) {
		Consulta consu = consultaService.registrar(consulta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consu.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Consulta consulta) {
		consultaService.modificar(consulta);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		
		Consulta consulta = consultaService.leer(id);
		if(consulta == null) {
			throw new ModeloNotFoundException(id + " no encontrado !");
		}else {
			consultaService.eliminar(id);	
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
