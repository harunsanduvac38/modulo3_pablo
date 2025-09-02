package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import modelo.Cliente;

public class TestHashMap {
	public static void main(String[] args) {
		Cliente c1 = new Cliente(16, "Adriana", "Jimenez", "Perez");
		Cliente c2 = new Cliente(123, "Juan", "Perez", "Lopez");
		Cliente c3 = new Cliente(168, "Pedro", "Vacis", "Miranda");
		Cliente c4 = new Cliente(516, "Susana", "García", "Pinto");
		Cliente c5 = new Cliente(44, "Adriana", "Jimenez", "Perez");

		
//		Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
		Map<Integer, Cliente> clientes = new LinkedHashMap<Integer, Cliente>();
		clientes.put(c1.getIdCliente(), c1);
		clientes.put(c2.getIdCliente(), c2);
		clientes.put(c3.getIdCliente(), c3);
		clientes.put(c4.getIdCliente(), c4);
		clientes.put(c5.getIdCliente(), c5);
		
		
		System.out.println(clientes.get(168));
		System.out.println(clientes.get(999));
		
		
		// Los maps no son iterables
		// Puedo obtener una colección de los valores o un set de las claves
		Collection<Cliente> valores = clientes.values();
		Set<Integer> claves = clientes.keySet();
		
		valores.forEach(System.out::println);
		claves.forEach(System.out::println);
		
		for(Integer clave : clientes.keySet()) {
			System.out.println(clave);
		}
		
		for(Cliente cli : clientes.values()) {
			System.out.println(cli);
		}
		
		//con entrySet() podemos obtener un Set de objetos Entry.
		// Un Entry representa un par de objetos, en este caso Integer,Cliente (Una clave y un valor)
		Set<Entry<Integer, Cliente>> entries = clientes.entrySet();
		
		System.out.println(entries.getClass().getName());
		
		for(Entry<Integer, Cliente> entrada : entries) {
			System.out.println(entrada.getKey() + ": " + entrada.getValue());
		}
		
		
		// Map ha incorporado el método forEach
		clientes.forEach((id,cli) -> System.out.println(id + ": " + cli));
	}
}
