package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.clases.ConnectionFactory;
import com.alura.jdbc.modelo.Producto;
import com.alura.jdbc.modelo.ProductoDAO;

public class ProductoController {

	public void modificar(Producto producto) throws SQLException {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("UPDATE PRODUCTO SET NOMBRE=? , DESCRIPCION= ?, CANTIDAD = ? WHERE ID = ?;");
			try (statement) {
				statement.setString(1, producto.getNombre());
				statement.setString(2, producto.getDescripcion());
				statement.setInt(3, producto.getCantidad());
				statement.setInt(4, producto.getId());

				statement.execute();
				System.out.println("ID " + producto.getId() + " fue actualizado");
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

	public void guardar(Producto producto) throws SQLException {
		var productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
		
		productoDAO.guardarProducto(producto);
	}	

}
