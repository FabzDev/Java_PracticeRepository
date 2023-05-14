package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramId  = req.getParameter("id"); 
		Integer id = Integer.valueOf(paramId);
		DB dataBaseParaUpdate = new DB();
		Empresa empresaParaUpdate = dataBaseParaUpdate.getEmpresa(id);
//		dataBaseParaUpdate.eliminarEmpresa(dataBaseParaUpdate.getEmpresa(id));
//		resp.sendRedirect("/gerenciador/formNuevaEmpresa.jsp");
		
		
		req.setAttribute("empresaObjeto", empresaParaUpdate);
		RequestDispatcher rd = req.getRequestDispatcher("/modificarEmpresa.jsp");
		rd.forward(req, resp);
		
	}
}
