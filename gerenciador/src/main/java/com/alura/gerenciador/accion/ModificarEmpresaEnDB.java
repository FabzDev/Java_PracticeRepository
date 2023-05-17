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

public class ModificarEmpresaEnDB {
	
	public void ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String nombre  = req.getParameter("name"); 
		String paramFechaApertura  = req.getParameter("date");
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
		
		resp.sendRedirect("entrada?accion=ListaEmpresas");
//		request.setAttribute("empresaObjeto", empresaParaUpdate);
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		rd.forward(request, response);
		
		System.out.println("Modificando empresa #" + id);

		
	}
}
