package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB database = new DB();
		List<Empresa> listaEmpresas = database.getEmpresas();
		
		PrintWriter out =response.getWriter();
		out.println("<html><body>");
		out.println("<ul>");
			for (Empresa empresa : listaEmpresas) {
				out.println("<li>" + empresa.getNombreEmpresa() + "</li>");
			}
		out.println("</ul>");
		out.println("</body></html>");
		
	}


}
