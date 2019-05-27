package com.rexsoft.clinic.app.dto;

public class ConsultaResumenDTO {
	private Integer cantidad;
	private String fecha;
	
	public ConsultaResumenDTO(Integer cantidad, String fecha) {
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	public ConsultaResumenDTO() {

	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
