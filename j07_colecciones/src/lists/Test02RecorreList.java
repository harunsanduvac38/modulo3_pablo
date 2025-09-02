package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test02RecorreList {
	public static void main(String[] args) {
		final int cant = 2_000_000;
		long t0, tf;
		
		List<String> al = new ArrayList<String>(cant);
		List<String> ll = new LinkedList<String>();
		
		cargaLista(al, cant);
		cargaLista(ll, cant);
		
		System.out.println("listas cargadas");
		System.out.println(al.size());
		System.out.println(ll.size());
		
		t0 = System.currentTimeMillis();
//		recorre(al);
		recorreIterator(al);
		tf = System.currentTimeMillis();
		System.out.println("ArrayList: " + (tf-t0));

		t0 = System.currentTimeMillis();
//		recorre(ll);
		recorreIterator(ll);
		tf = System.currentTimeMillis();
		System.out.println("LinkedList: " + (tf-t0));
		
	}
	
	public static void cargaLista(List<String> lista, int cant) {
		for (int i = 1; i <= cant; i++) {
			lista.add("objeto " + i);
		}
	}
	
	public static void recorre(List<String> lista) {
		for(int i = 0; i < lista.size(); i++) {
			String elemento = lista.get(i);
			//trabajo con elemento
		}
	}
	
	public static void recorreIterator(List<String> lista) {
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			String elemento = it.next();
			//trabajo con elemento
		}
	}
	
	public static void recorreForEach(List<String> lista) {
		for(String elemento : lista) {
			//trabajo con elemento
		}
	}
}
