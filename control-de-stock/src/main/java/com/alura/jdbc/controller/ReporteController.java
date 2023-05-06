package com.alura.jdbc.controller;

import java.util.List;

import com.alura.jdbc.clases.ConnectionFactory;
import com.alura.jdbc.modelo.Reporte;
import com.alura.jdbc.modelo.ReporteDAO;

public class ReporteController {

	private ReporteDAO reporteDAO;

	public ReporteController() {
		reporteDAO = new ReporteDAO(new ConnectionFactory().recuperaConexion());

	}

	public List<Reporte> cargaReporte() {
		return reporteDAO.cargaReporte();
	}

}
