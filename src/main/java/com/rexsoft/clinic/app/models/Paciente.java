package com.rexsoft.clinic.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Informacion del paciente")
@Entity
@Table(name = "pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	@ApiModelProperty(notes="Nombres debe tener minimo 3 caracteres")
	@Size(min = 3, message="Los nombres deben tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	@ApiModelProperty(notes="Los apellidos deben tener minimo 3 caracteres")
	@Size(min = 3, message="Los apellidos deben tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;
	@ApiModelProperty(notes="El DNI debe tener 10 caracteres")
	@Size(min = 10, max = 10, message="El DNI debe tener 10 caracteres")
	@Column(name = "dni", nullable = false, length = 10)
	private String dni;
	@ApiModelProperty(notes="La direccion debe tener minimo 3 caracteres")
	@Size(min = 3, max = 200, message="La direccion debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = true, length = 200)
	private String direccion;
	@ApiModelProperty(notes="El telefono debe tener minimo 7 caracteres")
	@Size(min = 7, max = 10, message="El telefono debe tener minimo 7 caracteres")
	@Column(name = "telefono", nullable = true, length = 10)
	private String telefono;
	@ApiModelProperty(notes="Email Valido")
	@Email
	@Column(name = "email", nullable = true, length = 55, unique = true)
	private String email;

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
