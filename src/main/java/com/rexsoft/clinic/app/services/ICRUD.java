package com.rexsoft.clinic.app.services;

import java.util.List;

public interface ICRUD<T> {

	public T registrar(T t);
	public T modificar(T t);
	public T leer(Integer id);
	public List<T> listartodos();
	public void eliminar(Integer id);
}
