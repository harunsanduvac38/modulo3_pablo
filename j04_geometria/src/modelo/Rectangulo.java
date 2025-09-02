package modelo;

public class Rectangulo extends Figura {
	private double lado1;
	private double lado2;
	
	public Rectangulo(double x, double y, double lado1, double lado2) {
		super(x, y);
		this.lado2 = lado2;
		this.lado1 = lado1;
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	
	@Override
	public double area() {
		return lado1 * lado2;
	}
	
	@Override
	public double perimetro() {
		return 2 * (lado1 + lado2);
	}
	
	@Override
	public boolean equals(Object otro) {
		if(!super.equals(otro)) return false;
		Rectangulo r = (Rectangulo)otro;
		return this.lado1 == r.lado1 && this.lado2 == r.lado2;
	}

	@Override
	public String toString() {
		return "Rectangulo [lado1=" + lado1 + ", lado2=" + lado2 + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}
	
	
}
