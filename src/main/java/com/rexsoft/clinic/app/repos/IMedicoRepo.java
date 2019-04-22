package com.rexsoft.clinic.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rexsoft.clinic.app.models.Medico;

public interface IMedicoRepo extends JpaRepository<Medico, Integer> {

}
