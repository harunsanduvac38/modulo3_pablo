package clasesdto;

import java.util.Objects;

public class ClienteDTO {

	private int idCliente;
	private String apellidos;
	private int nroCliente;
	private String categoria;
	
	public ClienteDTO(int idCliente, String apellidos, int nroCliente, String categoria) {
		this.idCliente = idCliente;
		this.apellidos = apellidos;
		this.nroCliente = nroCliente;
		this.categoria = categoria;
	}

	public int cliente() {
		return idCliente;
	}

	public String apellidos() {
		return apellidos;
	}

	public int nroliente() {
		return nroCliente;
	}

	public String categoria() {
		return categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, categoria, idCliente, nroCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(categoria, other.categoria)
				&& idCliente == other.idCliente && nroCliente == other.nroCliente;
	}

	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + ", apellidos=" + apellidos + ", nroCliente=" + nroCliente
				+ ", categoria=" + categoria + "]";
	}
	
}
