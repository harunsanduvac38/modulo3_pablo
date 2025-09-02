package tests;

import modelo.Circulo;
import modelo.Figura;
import modelo.Rectangulo;

public class Test03SumaAreas {

	
	public static double sumAreas(Figura... figs) {
		var suma = 0.0;
		for (int i = 0; i < figs.length; i++) {
			suma += figs[i].area();
		}
		return suma;
	}
	
	public static void main(String[] args) {
		
		var sumaTotal = sumAreas(new Circulo(1,2,3), new Rectangulo(1, 1, 3, 5));
		System.out.println(sumaTotal);
	}
}
