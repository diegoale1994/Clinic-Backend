package com.rexsoft.clinic.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rexsoft.clinic.app.models.Examen;

public interface IExamenRepo extends JpaRepository<Examen, Integer> {

}
