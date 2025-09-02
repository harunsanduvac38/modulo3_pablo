package tests;

import miscolecciones.genericos.Lista;
import miscolecciones.genericos.ListaArray;
import miscolecciones.genericos.ListaEnlazada;

public class Test02Genericos {
	public static void main(String[] args) {
		
		Lista<Integer> listaNum = new ListaArray<>();
		
		listaNum.agregar(156);
		listaNum.agregar(8);
		listaNum.agregar(90);
		listaNum.agregar(-155);
		listaNum.agregar(1569);
		listaNum.agregar(88);
		
		for (int i = 0; i < listaNum.largo(); i++) {
			System.out.println(listaNum.buscar(i));
		}
		
		for (Integer num : listaNum) {
			System.out.println(num);
		}
	}
}
