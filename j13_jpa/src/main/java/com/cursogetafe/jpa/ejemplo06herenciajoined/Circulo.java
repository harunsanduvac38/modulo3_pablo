package com.cursogetafe.jpa.ejemplo06herenciajoined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "circulo_02")
public class Circulo extends Figura {

	@Column(name = "r")
	private double radio;
	
	public Circulo() {}

	public Circulo(double x, double y, double radio) {
		super(x, y);
		this.radio = radio;
	}


	public double getRadio() {
		return radio;
	}


	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return 2 * radio;
	}
	
	@Override
	public double area() {
		return Math.PI * radio * radio;
	}
	
	@Override
	public double perimetro() {
		return Math.PI * getDiametro();
	}


	@Override
	public String toString() {
		return "Circulo (" + getX() + ", " + getY() + ", " + radio + ")";
	}

	
}
