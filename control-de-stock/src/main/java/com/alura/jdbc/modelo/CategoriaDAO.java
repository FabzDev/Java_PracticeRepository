package com.alura.jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.clases.ConnectionFactory;

public class CategoriaDAO {
	private Connection con;

	public CategoriaDAO(Connection con) {
		this.con = con;
	}

	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement("SELECT ID, NOMBRE FROM CATEGORIA");

			try (statement) {
				final ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					while (resultSet.next()) {
						Categoria categoria = new Categoria(resultSet.getInt("ID"), resultSet.getString("NOMBRE"));
						categorias.add(categoria);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return categorias;
	}
		
	}


