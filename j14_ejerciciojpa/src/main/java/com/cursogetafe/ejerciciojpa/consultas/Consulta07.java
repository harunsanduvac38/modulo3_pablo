package com.cursogetafe.ejerciciojpa.consultas;

import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.ClienteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta07 {
	public static void main(String[] args) {

		clientesDTO().forEach(System.out::println);
	}
	
	public static List<ClienteDTO> clientesDTO() {
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select c.idRol, c.persona.apellidos, c.nroCliente, c.categoria"
						+ " from Cliente c";
		
		TypedQuery<ClienteDTO> q = em.createQuery(jpql, ClienteDTO.class);
		
		return q.getResultList();
	}
	
}
