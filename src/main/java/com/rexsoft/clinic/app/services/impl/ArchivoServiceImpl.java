package com.rexsoft.clinic.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexsoft.clinic.app.models.Archivo;
import com.rexsoft.clinic.app.repos.IArchivoRepo;
import com.rexsoft.clinic.app.services.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService {

	@Autowired
	private IArchivoRepo archivoRepo;

	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = archivoRepo.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}

	@Override
	public byte[] leerArchivo(Integer idArchivo) {
		Archivo ar = archivoRepo.findById(idArchivo).orElse(null);
		if(ar != null) {
			return ar.getValue();
		}
		return null;
	}


}



