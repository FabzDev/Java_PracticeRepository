package com.alura.jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.jdbc.clases.ConnectionFactory;

public class ProductoDAO {
	final private Connection con;
	
	public ProductoDAO(Connection con) {
		this.con = con;
	}


	public void guardarProducto(Producto producto) throws SQLException {
		Integer cantidad = producto.getCantidad(); 
		Integer maxCant = 50;

		try (con) {
			con.setAutoCommit(false);
			
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO PRODUCTO(nombre, descripcion, cantidad) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				do {
					Integer cantFinal = Math.min(cantidad, maxCant);
					ejecutarRegistroEnGuardar(producto, cantFinal, statement);
					cantidad = cantidad - cantFinal;
				} while (cantidad > 0);
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
			}
		}
	}
	
	private void ejecutarRegistroEnGuardar(Producto producto,int cantF,
			PreparedStatement statement) throws SQLException {

		statement.setString(1, producto.getNombre());
		statement.setString(2, producto.getDescripcion());
		statement.setInt(3, cantF);

		statement.execute();

		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while (resultSet.next()) {
				producto.setId(resultSet.getInt(1));
				System.out.println(producto);
			}
		}
	}
}
