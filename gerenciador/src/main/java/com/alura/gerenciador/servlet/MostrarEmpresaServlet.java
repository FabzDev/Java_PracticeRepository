//package com.alura.gerenciador.servlet;
//
//import java.io.IOException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class MostrarEmpresaServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		String paramId  = req.getParameter("id");
//		Integer id = Integer.valueOf(paramId);
//		DB baseDeDatos = new DB();
//		
//		Empresa empresa = baseDeDatos.getEmpresa(id);
//		req.setAttribute("empresaObjeto", empresa);
//		RequestDispatcher rd = req.getRequestDispatcher("/mostrarEmpresa.jsp");
//		rd.forward(req, resp);
//		
////		resp.sendRedirect("listaEmpresas");
////		req.setAttribute("empresa", nuevaEmpresa.getNombreEmpresa());
//		
//	}
//}
