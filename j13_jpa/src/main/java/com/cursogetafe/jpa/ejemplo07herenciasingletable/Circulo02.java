package com.cursogetafe.jpa.ejemplo07herenciasingletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CIRCULO")
public class Circulo02 extends Figura02 {

	@Column(name = "r")
	private double radio;
	
	public Circulo02() {}

	public Circulo02(double x, double y, double radio) {
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
