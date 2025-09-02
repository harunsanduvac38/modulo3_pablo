package arrays;

import java.util.Arrays;
import java.util.Iterator;

import modelo.Cliente;

public class TestArrayOrden {
	public static void main(String[] args) {
		String[] ss = {"uno", "dos", "tres", "cuatro", "cinco"};
		
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
		System.out.println();
		
		Arrays.sort(ss);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
		System.out.println();
		
		
		Cliente c1 = new Cliente(16, "Adriana", "Jimenez", "Perez");
		Cliente c2 = new Cliente(123, "Juan", "Jimenez", "Perez");
		Cliente c3 = new Cliente(168, "Pedro", "Jimenez", "Perez");
		Cliente c4 = new Cliente(516, "Susana", "Jimenez", "Perez");
		
		Cliente[] clis = {c1, c2, c3, c4};
		Arrays.sort(clis);
		
		for (int i = 0; i < clis.length; i++) {
			System.out.println(clis[i]);
		}
	}
}
