package com.alura.gerenciador.accion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alura.gerenciador.servlet.DB;
import com.alura.gerenciador.servlet.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresa {

	public void ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("name");
		String paramFechaApertura = req.getParameter("date");
		Date fechaApertura;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaApertura = sdf.parse(paramFechaApertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa nuevaEmpresa = new Empresa();
		nuevaEmpresa.setNombreEmpresa(nombre);
		nuevaEmpresa.setFechaApertura(fechaApertura);

		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(nuevaEmpresa);

		resp.sendRedirect("entrada?accion=ListaEmpresas");

//		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//		req.setAttribute("empresa", nuevaEmpresa.getNombreEmpresa());
//		rd.forward(req, resp);
		
		System.out.println("Creada nueva empresa: " + nombre);

	}

}
