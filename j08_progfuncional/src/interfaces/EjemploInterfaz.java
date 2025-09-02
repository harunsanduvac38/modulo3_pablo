package interfaces;

public interface EjemploInterfaz {

	static int numerito = 34;
	
	//Antes de Java8, sólo existían métodos abstractos en una interfaz
	// Java8 incorpora métodos estáticos y default
	// Java11 incorpora métodos private
	
	
	//métodos abstractos
	void procesa(String str);
	
	int otroProceso();
	
	
	//métodos default
	default void haceAlgo() {
		System.out.println("soy el método default!!!");
	}
	
	//métodos static
	static void metodoEstatico() {
		System.out.println("yo son estático");
	}
	
	//métodos private
	private String metodoPrivado() {
		return "soy privado";
	}
	
	default void metodoDefaultUsaPrivate() {
		System.out.println(metodoPrivado());
	}
	
	//métodos private static
	private static String metodoStaticPrivado() {
		return "soy privado y estático";
	}
	
	static void metodoStaticUsaPrivate() {
		System.out.println(metodoStaticPrivado());
	}
}
