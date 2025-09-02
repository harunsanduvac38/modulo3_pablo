package miscolecciones;

public class ListaEnlazada implements Lista {

	private Nodo primero;
	private Nodo ultimo;
	private int cant;
	
	@Override
	public void agregar(String dato) {
		Nodo nuevo = new Nodo(dato);
		if (primero == null)
			primero = nuevo;
		else
			ultimo.siguiente = nuevo;
		
		ultimo = nuevo;
		cant++;
		
	}

	@Override
	public String eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscar(int pos) {
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
		String dato;
		Nodo siguiente;
		
		Nodo(String dato){
			this.dato = dato;
		}
	}
}
