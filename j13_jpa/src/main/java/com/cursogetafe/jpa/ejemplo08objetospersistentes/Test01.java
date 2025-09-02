package com.cursogetafe.jpa.ejemplo08objetospersistentes;

import com.cursogetafe.jpa.config.Config;
import com.cursogetafe.jpa.ejemplo01mapeosimple.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Config.getEmf();
		EntityManager em = emf.createEntityManager();

		
		Persona p = em.find(Persona.class, 12);
		if(p != null)
			System.out.println(p);
		else
			System.out.println("Este tio no existe!");
		p.setApodo("Otro apodo");
		// sigo currando...
		
//		Persona nueva = new Persona(0, "Ape Nuevo", "Nombre nuevo");
//		em.getTransaction().begin();
//		em.persist(nueva);
//		em.getTransaction().commit();
		
		em.close();
	}
}
