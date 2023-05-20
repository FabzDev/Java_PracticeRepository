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

public class ModificarEmpresaEnDB implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Controller ModificarEmpresaEnDB");

		
		String stringId = req.getParameter("idMod");
		Integer id = Integer.valueOf(stringId);
		
		String nombre = req.getParameter("nombreMod");
		String paramFechaApertura = req.getParameter("fechaMod");
		Date fechaApertura;
		
		//formateando fecha
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaApertura = sdf.parse(paramFechaApertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		DB db = new DB();
		Empresa empresaDB = db.getEmpresa(id);
		
		empresaDB.setNombreEmpresa(nombre);
		empresaDB.setFechaApertura(fechaApertura);

		return "redirect:entrada?accion=ListaEmpresas";

	}
}
