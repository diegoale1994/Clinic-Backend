package com.rexsoft.clinic.app.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.rexsoft.clinic.app.dto.ConsultaDTO;
import com.rexsoft.clinic.app.dto.ConsultaListaExamenDTO;
import com.rexsoft.clinic.app.dto.ConsultaResumenDTO;
import com.rexsoft.clinic.app.dto.FiltroConsultaDTO;
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
	
	@GetMapping(value="/hateoas", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ConsultaDTO> listarHateoas(){
		List<Consulta> consultas = new ArrayList<>();
		List<ConsultaDTO> consultasDTO = new ArrayList<>();
		consultas = consultaService.listartodos();
		for(Consulta c: consultas) {
			ConsultaDTO d = new ConsultaDTO();
			d.setIdConsulta(c.getIdConsulta());
			d.setMedico(c.getMedico());
			d.setPaciente(c.getPaciente());
			
			//consultas
			ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(c.getIdConsulta()));
			d.add(linkTo.withSelfRel());
			
			//pacientes
			ControllerLinkBuilder linkTo1 = linkTo(methodOn(PacienteController.class).listarPorId(c.getPaciente().getIdPaciente()));
			d.add(linkTo1.withSelfRel());
			
			ControllerLinkBuilder linkTo2 = linkTo(methodOn(MedicoController.class).listarPorId(c.getMedico().getIdMedico()));
			d.add(linkTo2.withSelfRel());
			consultasDTO.add(d);
		}
		return consultasDTO;
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
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registrar(@Valid @RequestBody ConsultaListaExamenDTO consulta) {
		Consulta consu = consultaService.registrarTransaccional(consulta);
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
	
	@PostMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Consulta>> buscar(@RequestBody FiltroConsultaDTO filtro){
		List<Consulta> consultas = new ArrayList<>();
		
		if(filtro != null) {
			if(filtro.getFechaConsulta() != null) {
				consultas = consultaService.buscarfecha(filtro);
			}else {
				consultas = consultaService.buscar(filtro);
			}
		}
		return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarResumen", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConsultaResumenDTO>> listarResumen() {
		List<ConsultaResumenDTO> consultas = consultaService.listaResumen();
		return new ResponseEntity<List<ConsultaResumenDTO>>(consultas, HttpStatus.OK);
	}
}
