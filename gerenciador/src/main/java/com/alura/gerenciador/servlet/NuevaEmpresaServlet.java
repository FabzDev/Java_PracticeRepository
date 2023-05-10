package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println( nombre + ": Empresa registrada con exito");
		out.println("</html>");
		
	}
}
