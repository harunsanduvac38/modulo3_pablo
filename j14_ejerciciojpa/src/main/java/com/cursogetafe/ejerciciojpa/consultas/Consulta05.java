package com.cursogetafe.ejerciciojpa.consultas;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta05 {
	public static void main(String[] args) {
		EntityManager em = Config.getEmf().createEntityManager();
		
		// Busca todos los clientes con todos sus datos que por defecto están en modo eager.
		// No carga los productos (lazy)
		// Para cargar los datos de la Persona, realiza una consulta por cada idRol
		String jpql1 = "select c from Cliente c";
		
		// Realiza una consulta con join a personas con todos los datos
		// No carga los productos (lazy)
		String jpql2 = "select c from Cliente c join fetch c.persona";
		
		// Realiza una sola consulta de clientes join roles join personas join clientes_productos join productos
		// Devuelve los productos en modo eager
		String jpql3 = "select c from Cliente c join fetch c.persona left join fetch c.productos";
		
		TypedQuery<Cliente> q = em.createQuery(jpql3, Cliente.class);
		
		for (Cliente cli : q.getResultList()) {
			System.out.println(cli);
//			System.out.println("\t" + cli.getProductos());
			if(cli.getIdRol() == 12)
				System.out.println(cli.getProductos());
		}
	}
}
