package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Nueva empresa registrada");
		String nombreEmpresa = req.getParameter("nombre");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>" +nombreEmpresa+ ": Nueva empresa registrada</body></html>");
	}

}
