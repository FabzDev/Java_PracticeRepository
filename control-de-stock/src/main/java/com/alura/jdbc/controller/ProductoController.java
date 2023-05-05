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

	private ProductoDAO productoDAO;
	
	public ProductoController() {
		productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());		
	}
	
	public void modificar(Producto producto) throws SQLException {
		Connection con = productoDAO.getCon();
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

	public List<Producto> listar() {
		return productoDAO.listar();
			}

	public void guardar(Producto producto) {
		var productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
		productoDAO.guardarProducto(producto);
	}	

}
