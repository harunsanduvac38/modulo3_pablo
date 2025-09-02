package equals;

public class Cliente {

	private int idCliente;
	private String nombre;
	private String apellidos;
	
	public Cliente(int idCliente, String nombre, String apellidos) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public boolean equals(Object otro) {
		if(otro == null) return false;
		if(this == otro) return true;
		if(this.getClass() != otro.getClass()) return false;
		Cliente o = (Cliente)otro;
		return this.idCliente == o.idCliente;
	}
}
