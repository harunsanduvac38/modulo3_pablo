package com.cursogetafe.jpa.ejemplo01mapeosimple;

import com.cursogetafe.jpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Config.getEmf();
		
		EntityManager em = emf.createEntityManager();
		
//		String sql = "select idpersona, apellidos, nombre, apodo, dni from persona where idpersona = ?";
//		PreparedStatemen ps = cx.prepareStatement(sql);
//		ps.setInt(1, 12);
//		ResultSet rs = ps.executeQuery();
//		if(rs.next()) {
//			Persona p = new Persona();
//			p.setApellidos);
//			...
//		}
		
		Persona p = em.find(Persona.class, 12);
		if(p != null)
			System.out.println(p);
		else
			System.out.println("Este tio no existe!");
		
		em.close();
	}
}
