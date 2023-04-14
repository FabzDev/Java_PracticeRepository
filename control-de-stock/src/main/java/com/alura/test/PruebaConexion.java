package com.alura.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/control_de_stock?userTimeZone=true&serverTimeZone=UTC",
				"root", "faeavf44");
		
		System.out.println("Cerrando la conexion");
		
		con.close();
	}
}
