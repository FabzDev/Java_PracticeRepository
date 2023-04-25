package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

	public Connection methodConectionFactory(String url, String user, String pass) throws SQLException {
		return DriverManager.getConnection(url, user, pass);
		
	}
}
