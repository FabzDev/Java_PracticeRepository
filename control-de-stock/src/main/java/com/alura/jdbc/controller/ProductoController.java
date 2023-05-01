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
		final Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("UPDATE PRODUCTO SET NOMBRE=? , DESCRIPCION= ?, CANTIDAD = ? WHERE ID = ?;");
			try (statement) {
				statement.setString(1, nombre);
				statement.setString(2, descripcion);
				statement.setInt(3, cantidad);
				statement.setInt(4, id);

				statement.execute();
				System.out.println("ID " + id + " fue actualizado");
			}
		}
	}

	public int eliminar(Integer id) throws SQLException {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID =?");
			try (statement) {
				statement.setInt(1, id);

				statement.execute();

				return statement.getUpdateCount();
			}
		}
	}

	public List<Map<String, String>> listar() throws SQLException {

		final Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");
			try (statement) {
				statement.execute();
				final ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					List<Map<String, String>> result = new ArrayList<>();
					while (resultSet.next()) {
						Map<String, String> fila = new HashMap<>();
						fila.put("ID", String.valueOf(resultSet.getInt("ID")));
						fila.put("NOMBRE", resultSet.getString("NOMBRE"));
						fila.put("DESCRIPCION", resultSet.getString("DESCRIPCION"));
						fila.put("CANTIDAD", String.valueOf(resultSet.getInt("CANTIDAD")));

						result.add(fila);
					}

					return result;
				}
			}
		}
	}

	public void guardar(Map<String, String> producto) throws SQLException {
		String nombre = producto.get("NOMBRE");
		String descripcion = producto.get("DESCRIPCION");
		Integer cantidad = Integer.valueOf(producto.get("CANTIDAD")); // 80
		Integer maxCant = 50;

		final Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			con.setAutoCommit(false);

			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO PRODUCTO(nombre, descripcion, cantidad) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				do {
					Integer cantFinal = Math.min(cantidad, maxCant);
					ejecutarRegistroEnGuardar(nombre, descripcion, cantFinal, statement);
					cantidad = cantidad - cantFinal;
				} while (cantidad > 0);
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
			}
		}
	}

	private void ejecutarRegistroEnGuardar(String nombre, String descripcion, Integer cantidad,
			PreparedStatement statement) throws SQLException {

		statement.setString(1, nombre);
		statement.setString(2, descripcion);
		statement.setInt(3, cantidad);

		statement.execute();

		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while (resultSet.next()) {
				System.out.println("Fue insertado el producto " + resultSet.getInt(1));
			}
		}
	}

}
