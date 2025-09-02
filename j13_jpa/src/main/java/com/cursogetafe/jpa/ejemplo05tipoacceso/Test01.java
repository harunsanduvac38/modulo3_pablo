package com.cursogetafe.jpa.ejemplo05tipoacceso;

import com.cursogetafe.jpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Config.getEmf();
		
		EntityManager em = emf.createEntityManager();

		
		Persona05 p = em.find(Persona05.class, 12);
		if(p != null)
			System.out.println(p);
		else
			System.out.println("Este tio no existe!");
		
		em.close();
	}
}
