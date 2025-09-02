package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class Prueba01 {

	public static void main(String[] args) {
		
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl("jdbc:mysql://localhost:3366/11_agenda");
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUsername("root");
		bds.setPassword("root");
		
		DataSource ds = bds;
		
		try (Connection cx = ds.getConnection()){
			
			PreparedStatement ps = 
				cx.prepareStatement("select nombre, apodo from contactos where idcontactos < 30");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("nombre") + " - " + rs.getString("apodo"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
