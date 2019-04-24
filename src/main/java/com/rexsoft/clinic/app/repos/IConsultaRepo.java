package com.rexsoft.clinic.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rexsoft.clinic.app.models.Consulta;

public interface IConsultaRepo extends JpaRepository<Consulta, Integer> {

}
