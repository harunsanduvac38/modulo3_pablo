package com.cursogetafe.jpa.ejemplo12muchosamuchos;

import java.util.Set;

import com.cursogetafe.jpa.config.Config;

import jakarta.persistence.EntityManager;

public class Test01 {

	public static void main(String[] args) {
		EntityManager em = Config.getEmf().createEntityManager();
		
		Jugador j = em.find(Jugador.class, 5); //busca jugador 5
		System.out.println(j);
		
//		System.out.println(j.getEquipos()); //carga los equipos
		
		Set<Equipo> equipos = j.getEquipos();
		
		equipos.forEach(e -> System.out.println(e.getEquipo()));
	}

}
