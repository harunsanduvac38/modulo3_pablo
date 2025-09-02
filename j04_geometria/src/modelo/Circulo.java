package modelo;

public class Circulo extends Figura implements Dibujable {

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
	public boolean equals(Object otro) {
		if(!super.equals(otro)) return false;
		Circulo c = (Circulo) otro;
		return this.radio == c.radio;
	}


	@Override
	public String toString() {
		return "Circulo (" + getX() + ", " + getY() + ", " + radio + ")";
	}


	@Override
	public void dibujar() {
		System.out.println("dibujando el circulito");
	}
	
}
