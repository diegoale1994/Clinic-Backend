package com.rexsoft.clinic.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rexsoft.clinic.app.models.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer> {

}
