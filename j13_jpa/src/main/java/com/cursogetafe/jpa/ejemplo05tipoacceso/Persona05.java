package com.cursogetafe.jpa.ejemplo05tipoacceso;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "persona")
public class Persona05 implements Serializable {

	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	public Persona05() {
		System.out.println("Constructor por defecto");
	}
	
	public Persona05(int idPersona, String apellidos, String nombre) {
		super();
		this.idPersona = idPersona;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}

//  Access Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		System.out.println("setIdPersona()");
		this.idPersona = idPersona;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		System.out.println("setApellidos()");
		this.apellidos = apellidos;
	}

	@Column(name = "apodo")
	public String getElApodo() {
		return apodo;
	}

	public void setElApodo(String apodo) {
		System.out.println("setApodo()");
		this.apodo = apodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Transient
	public String getNombreCompleto() {
		return nombre + " " + apellidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona05 other = (Persona05) obj;
		return idPersona == other.idPersona;
	}

	@Override
	public String toString() {
		return "Persona (" + idPersona + ", " + apellidos + ", " + apodo + ", " + nombre + ", " + dni + ")";
	}
}
