package com.rexsoft.clinic.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rexsoft.clinic.app.models.Consulta;
import com.rexsoft.clinic.app.models.ConsultaExamen;

public interface IConsultaExamenRepo extends JpaRepository<Consulta, Integer> {

	//@Transactional
	@Modifying
	@Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idConsulta, :idExamen)", nativeQuery= true)
	public Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);
	@Query("from ConsultaExamen ce WHERE ce.consulta.idConsulta =:idConsulta")
	List<ConsultaExamen> listarExamenesPorConsulta(@Param("idConsulta") Integer idConsulta);
}
