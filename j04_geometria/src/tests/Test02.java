package tests;

import modelo.Figura;
import modelo.Rectangulo;

public class Test02 {

	public static void main(String[] args) {
		var r1 = new Rectangulo(1, 2, 3, 4);
		Rectangulo r2 = new Rectangulo(1, 2, 3, 4);
		
		System.out.println(r1.getX());
		System.out.println(r1.getLado1());
		System.out.println(r1.area());
		System.out.println(r1.toString());
		System.out.println(r1.equals(r2));
		
		Figura f = r1;
		
		System.out.println(f.area());
		System.out.println(f.toString());
		System.out.println(f.equals(f));
		
		Object o = r1;
		System.out.println(o.toString());
		System.out.println(o.getClass().getName());
	}
	
	
}
