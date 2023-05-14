package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ModificadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String nombre  = request.getParameter("name"); 
		String paramFechaApertura  = request.getParameter("date");
		Date fechaApertura;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaApertura = sdf.parse(paramFechaApertura);
		} catch (ParseException e) {
			throw new ServletException(e);}
		
//		Empresa nuevaEmpresa = new Empresa();
//		nuevaEmpresa.setNombreEmpresa(nombre);
//		nuevaEmpresa.setFechaApertura(fechaApertura);
		
		DB baseDeDatos = new DB();
		Empresa empresaParaActualizar = baseDeDatos.getEmpresa(id);
		empresaParaActualizar.setNombreEmpresa(nombre);
		empresaParaActualizar.setFechaApertura(fechaApertura);
		
		response.sendRedirect("listaEmpresas");
//		request.setAttribute("empresaObjeto", empresaParaUpdate);
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		rd.forward(request, response);
		
	}
}
