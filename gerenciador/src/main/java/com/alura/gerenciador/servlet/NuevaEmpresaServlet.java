package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre  = req.getParameter("name"); 
		
		Empresa nuevaEmpresa = new Empresa();
		nuevaEmpresa.setNombreEmpresa(nombre);
		
		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(nuevaEmpresa);
		
		RequestDispatcher rd = req.getRequestDispatcher("/nuevaEmpresaRegistrada.jsp");
		req.setAttribute("empresa", nuevaEmpresa.getNombreEmpresa());
		rd.forward(req, resp);
		
	}
}
