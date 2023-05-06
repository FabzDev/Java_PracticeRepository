package com.alura.jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {
	
	private Connection con;
	
	public ReporteDAO(Connection con) {
		this.con = con;
	}

	public List<Reporte> cargaReporte() {
		List<Reporte> listaReporte = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement("SELECT producto.nombre NombreProducto, "
					+ "categoria.nombre NombreCategoria FROM producto JOIN categoria ON "
					+ "producto.categoria_id = categoria.id");

			try (statement) {
				final ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					while (resultSet.next()) {
						Reporte reporte = new Reporte(resultSet.getString("NombreProducto"), resultSet.getString("NombreCategoria"));
						listaReporte.add(reporte);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaReporte;
	}
}
