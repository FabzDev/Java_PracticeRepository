package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.clases.ConnectionFactory;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer cantidad, Integer id) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		PreparedStatement statement = con.prepareStatement("UPDATE PRODUCTO SET NOMBRE=? , DESCRIPCION= ?, CANTIDAD = ? WHERE ID = ?;");
		
		statement.setString(1, nombre);
		statement.setString(2, descripcion);
		statement.setInt(3, Integer.valueOf(cantidad));
		statement.setInt(4, Integer.valueOf(id));
	
		statement.execute();
		System.out.println("ID " + id + " fue actualizado");
		con.close();
	}

	public int eliminar(Integer id) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID =?");
		
		statement.setInt(1, Integer.valueOf(id));

		statement.execute();
		return statement.getUpdateCount();
	}

	public List<Map<String, String>> listar() throws SQLException {
		// 1. crear conexion
		Connection con = new ConnectionFactory().recuperaConexion();
		// 2. crear objeto statement
		Statement statement = con.createStatement();

		// 3. Ejecutar execute
		statement.execute("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

		// 4. obtener el resultado de statement.execute
		ResultSet resultSet = statement.getResultSet();

		// 5. iterar el resultado y guardarlo en un nuevo array
		List<Map<String, String>> result = new ArrayList<>(); // creando array vacio

		while (resultSet.next()) { // iterando el resultado y agregandolo al array vacio previamente creado
			Map<String, String> fila = new HashMap<>();
			fila.put("ID", String.valueOf(resultSet.getInt("ID")));
			fila.put("NOMBRE", resultSet.getString("NOMBRE"));
			fila.put("DESCRIPCION", resultSet.getString("DESCRIPCION"));
			fila.put("CANTIDAD", String.valueOf(resultSet.getInt("CANTIDAD")));

			result.add(fila);
		}

		con.close();

		return result;
	}

	public void guardar(Map<String, String> producto) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		PreparedStatement statement = con.prepareStatement(
				"INSERT INTO PRODUCTO(nombre, descripcion, cantidad) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, producto.get("NOMBRE"));
		statement.setString(2, producto.get("DESCRIPCION"));
		statement.setInt(3, Integer.valueOf(producto.get("CANTIDAD")));
		
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println("Fue insertado el producto " + resultSet.getInt(1));
		}
	}

}
