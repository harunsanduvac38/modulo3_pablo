package interfaces;

public class TestInterfaces {
	public static void main(String[] args) {
		
		
		EjemploInterfaz iNormal = new EjemploInterfaz() {
			@Override
			public void procesa(String str) {
				System.out.println("desde procesa " + str);
			}
			
			@Override
			public int otroProceso() {
				return 2025;
			}
		};
		
		iNormal.procesa("hola que tal");
		System.out.println(iNormal.otroProceso());
		
		MiInterfazFuncional iFuncional = new MiInterfazFuncional() {
			
			@Override
			public void haceAlgo() {
				System.out.println("haciendo algo...");
			}
		};
		
		iFuncional.haceAlgo();
		
		//Podemos utilizar una expresión lambda
	
		
		MiInterfazFuncional iFuncional2 = () -> {
			System.out.println("soy haceAlgo desde lambda");
		};
		iFuncional2.haceAlgo();
	}
}
