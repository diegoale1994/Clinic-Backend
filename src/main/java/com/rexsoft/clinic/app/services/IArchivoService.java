package com.rexsoft.clinic.app.services;

import com.rexsoft.clinic.app.models.Archivo;

public interface IArchivoService {
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
}
