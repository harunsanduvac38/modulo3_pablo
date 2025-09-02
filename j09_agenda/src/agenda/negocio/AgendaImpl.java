package agenda.negocio;

import java.io.IOException;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;
import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoJDBC;
import agenda.persistencia.ContactoDaoMem;
import agenda.persistencia.ContactoDaoMemSerial;

public class AgendaImpl implements Agenda {
	
	private ContactoDao cDao;
	
	public AgendaImpl() {
//		cDao = new ContactoDaoMem();
//		cDao = new ContactoDaoMemSerial();
		cDao = new ContactoDaoJDBC();
	}

	@Override
	public void insertarContacto(Contacto c) {
		cDao.insertar(c);
	}

	@Override
	public Contacto eliminar(int idContacto) {
		Contacto aEliminar = cDao.buscar(idContacto);
		cDao.eliminar(idContacto);
		return aEliminar;
	}

	@Override
	public boolean eliminar(Contacto c) {
		return eliminar(c.getIdContacto()) != null;
	}

	@Override
	public void modificar(Contacto c) {
		cDao.actualizar(c);
	}

	@Override
	public Set<Contacto> buscarTodos() {
		Set<Contacto> resu = new TreeSet<Contacto>(getComparatorApodo());
		resu.addAll(cDao.buscarTodos());
		return resu;
	}

	@Override
	public Set<Contacto> buscarContactoPorNombre(String buscado) {
		Set<Contacto> resu = new TreeSet<Contacto>(getComparatorApodo());
		resu.addAll(cDao.buscar(buscado));
		return resu;
	}

	private Comparator<Contacto> getComparatorApodo(){
		return (c1, c2) -> {
			Collator col = Collator.getInstance(new Locale("es"));
			return col.compare(c1.getApodo(), c2.getApodo());
		};
	}
	
	@Override
	public int importarCSV(String fichero) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contacto buscar(int idContacto) {
		return cDao.buscar(idContacto);
	}

}
