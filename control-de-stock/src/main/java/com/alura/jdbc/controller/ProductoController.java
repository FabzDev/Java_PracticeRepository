package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.clases.ConnectionFactory;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public void eliminar(Integer id) {
		// TODO
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
		Statement statement = con.createStatement();
		statement.execute(
				"INSERT INTO PRODUCTO(nombre, descripcion, cantidad)" + " VALUES('" + producto.get("NOMBRE") + "', '"
						+ producto.get("DESCRIPCION") + "', " + producto.get("CANTIDAD") + ")",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println("Fue insertado el producto " + resultSet.getInt(1));

		}

	}

}
