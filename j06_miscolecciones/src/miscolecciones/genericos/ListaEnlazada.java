package miscolecciones.genericos;

import java.util.Iterator;

public class ListaEnlazada<T> implements Lista<T> {

	private Nodo primero;
	private Nodo ultimo;
	private int cant;
	
	@Override
	public void agregar(T dato) {
		Nodo nuevo = new Nodo(dato);
		if (primero == null)
			primero = nuevo;
		else
			ultimo.siguiente = nuevo;
		
		ultimo = nuevo;
		cant++;
	}

	@Override
	public T eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T buscar(int pos) {
		if(pos < 0 || pos >= cant)
			return null;
		
		if(pos == 0)
			return primero.dato;
		
		if(pos == cant -1)
			return ultimo.dato;
		
		return anterior(pos).siguiente.dato;
	}
	
	private Nodo anterior(int pos) {
		Nodo aux = primero;
		for (int i = 0; i < pos -1; i++) {
			aux = aux.siguiente;
		}
		return aux;
	}

	@Override
	public boolean vacia() {
		return cant == 0;
	}

	@Override
	public int largo() {
		return cant;
	}

	
	private class Nodo {
		T dato;
		Nodo siguiente;
		
		Nodo(T dato){
			this.dato = dato;
		}
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
