package com.alura.gerenciador.accion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class NuevaEmpresa implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Controller Nueva Empresa");
		
		String nombre = req.getParameter("nombre");
		String paramFechaApertura = req.getParameter("fecha");
		Date fechaApertura;
		
		//formateando fecha
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaApertura = sdf.parse(paramFechaApertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa nuevaEmpresa = new Empresa();
		nuevaEmpresa.setNombreEmpresa(nombre);
		nuevaEmpresa.setFechaApertura(fechaApertura);

		DB db = new DB();
		db.agregarEmpresa(nuevaEmpresa);

		return "redirect:entrada?accion=ListaEmpresas";

	}

}
