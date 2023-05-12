package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramId  = req.getParameter("id"); 
		Integer id = Integer.valueOf(paramId);
		DB dataBaseParaDelete = new DB();
		dataBaseParaDelete.eliminarEmpresa(dataBaseParaDelete.getEmpresa(id));
		
		
		resp.sendRedirect("listaEmpresas");
//		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//		rd.forward(req, resp);
		
	}
}
