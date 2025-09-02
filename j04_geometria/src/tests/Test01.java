package tests;

import java.awt.Rectangle;

import modelo.Circulo;
import modelo.Figura;
import modelo.Rectangulo;

public class Test01 {
	public static void main(String[] args) {
//		Figura f = new Figura();
//		System.out.println(f);
		
		
		Rectangulo r = new Rectangulo(-1.5, 3.74, 10, 5);
		
		System.out.println(r.area());
		
		System.out.println(r);
		
		
		Circulo c1 = new Circulo(1, 2, 3);
		Circulo c2 = new Circulo(1, 2, 3);

		System.out.println(c1);
		
		System.out.println(c1.equals(c2));
	}
}
