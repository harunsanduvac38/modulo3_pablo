package miscolecciones.genericos;

import java.util.Iterator;

public class ListaArray<T> implements Lista<T> {

	private Object[] almacen;
	private int cant;
	
	public ListaArray() {
		this(10);
	}
	
	public ListaArray(int tamanyo) {
		super();
		almacen = new Object[tamanyo];
	}
	
	@Override
	public void agregar(T dato) {
		if(almacen.length == cant)
			redimensionar();
		almacen[cant++] = dato;
	}

	@Override
	public T eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscar(int pos) {
		if(pos < 0 || pos >= cant)
//			throw new ArrayIndexOutOfBoundsException();
			return null;
		return (T)almacen[pos];
	}

	@Override
	public boolean vacia() {
		return cant == 0;
	}

	@Override
	public int largo() {
		return cant;
	}
	
	private void redimensionar() {
		Object[] nuevo = new Object[almacen.length * 2];
		for (int i = 0; i < almacen.length; i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}

	@Override
	public Iterator<T> iterator() {
		return new Pepito<>();
	}

	private class Pepito<T> implements Iterator<T>{

		private int punteroAux = 0;
		
		@Override
		public boolean hasNext() {
			return punteroAux < cant;
		}

		@Override
		public T next() {
			return (T)almacen[punteroAux++];
		}
		
	}
}
