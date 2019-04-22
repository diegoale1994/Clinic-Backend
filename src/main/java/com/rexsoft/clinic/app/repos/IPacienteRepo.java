package com.rexsoft.clinic.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rexsoft.clinic.app.models.Paciente;

public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
