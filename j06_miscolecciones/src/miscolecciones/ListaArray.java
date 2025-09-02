package miscolecciones;

public class ListaArray implements Lista {

	private String[] almacen;
	private int cant;
	
	public ListaArray() {
		this(10);
	}
	
	public ListaArray(int tamanyo) {
		super();
		almacen = new String[tamanyo];
	}
	
	@Override
	public void agregar(String dato) {
		if(almacen.length == cant)
			redimensionar();
		almacen[cant++] = dato;
	}

	@Override
	public String eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscar(int pos) {
		if(pos < 0 || pos >= cant)
//			throw new ArrayIndexOutOfBoundsException();
			return null;
		return almacen[pos];
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
		String[] nuevo = new String[almacen.length * 2];
		for (int i = 0; i < almacen.length; i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}

}
