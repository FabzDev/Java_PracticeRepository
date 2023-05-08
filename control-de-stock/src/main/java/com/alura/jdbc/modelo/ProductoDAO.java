package com.alura.jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.clases.ConnectionFactory;

public class ProductoDAO {
	
	final private Connection con;

	public ProductoDAO(Connection con) {
		this.con = con;
	}

	public void guardarProducto(Producto producto) {
		Integer cantidad = producto.getCantidad();
		Integer maxCant = 50;
//		Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			con.setAutoCommit(false);

			final String sqlQuery = "INSERT INTO PRODUCTO(nombre, descripcion, cantidad, categoria_id) VALUES(?,?,?,?)";
			System.out.println(sqlQuery);
			PreparedStatement statement = con.prepareStatement(
					sqlQuery,
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
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutarRegistroEnGuardar(Producto producto, int cantF, PreparedStatement statement)
			throws SQLException {

		statement.setString(1, producto.getNombre());
		statement.setString(2, producto.getDescripcion());
		statement.setInt(3, cantF);
		statement.setInt(4, producto.getCategoriaId());

		statement.execute();

		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while (resultSet.next()) {
				producto.setId(resultSet.getInt(1));
			}
		}
	}

	public List<Producto> listar() {
		Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD, CATEGORIA_ID FROM PRODUCTO");
			try (statement) {
				statement.execute();
				final ResultSet resultSet = statement.getResultSet();
				System.out.println(resultSet);
				try (resultSet) {
					List<Producto> productos = new ArrayList<>();
					while (resultSet.next()) {
						Producto result = new Producto(resultSet.getInt("ID"), resultSet.getString("NOMBRE"),
								resultSet.getString("DESCRIPCION"), resultSet.getInt("CANTIDAD"), resultSet.getInt("CATEGORIA_ID"));
						productos.add(result);
					}

					return productos;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Producto> listar(Integer categoriaId) {
		Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO WHERE CATEGORIA_ID = ?");
							
			try (statement) {
				statement.setInt(1, categoriaId);
				statement.execute();
				final ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					List<Producto> productos = new ArrayList<>();
					while (resultSet.next()) {
						Producto result = new Producto(resultSet.getInt("ID"), resultSet.getString("NOMBRE"),
								resultSet.getString("DESCRIPCION"), resultSet.getInt("CANTIDAD"));
						productos.add(result);
					}

					return productos;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void modificar(Producto producto) {
		Connection con = new ConnectionFactory().recuperaConexion();
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
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int eliminar(Integer id) {
		Connection con = new ConnectionFactory().recuperaConexion();
		try (con) {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID =?");
			try (statement) {
				statement.setInt(1, id);

				statement.execute();

				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
