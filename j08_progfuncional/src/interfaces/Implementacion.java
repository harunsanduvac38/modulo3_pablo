package interfaces;

public class Implementacion implements EjemploInterfaz {

	@Override
	public void procesa(String str) {
		// TODO Auto-generated method stub
	}

	@Override
	public int otroProceso() {
		// TODO Auto-generated method stub
		return 0;
	}

	//no es obligatorio, si quiero puedo sobreescribir cualquier método default
	@Override
	public void haceAlgo() {
		// TODO Auto-generated method stub
		EjemploInterfaz.super.haceAlgo();
	}
}
