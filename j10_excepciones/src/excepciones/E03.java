package excepciones;

import java.sql.SQLException;

public class E03 {

	
	public static void main(String[] args) {
		try {
			metodo(-5);
		} catch (SQLException e) {
			System.out.println("ESto arregla el problema");
			e.printStackTrace();
		}
		System.err.println("Continua el programa");
		
		otroMetodo(66);
	}
	
	public static void otroMetodo(int num) {
		try {
			problematico(num);
		} catch (SQLException e) {
			// esto es el arreglo del problema!!!!!
			
		}
	}
	
	public static void metodo(int num) throws SQLException {
		problematico(num);
		System.out.println("todo fenomenal");
	}
	
	
	
	public static void problematico(int valor) throws SQLException, IllegalArgumentException {
		if(valor == 0)
			throw new IllegalArgumentException();
		if(valor < 0) {
			throw new SQLException("esto ha explotado!!!");
		}
	}
}
