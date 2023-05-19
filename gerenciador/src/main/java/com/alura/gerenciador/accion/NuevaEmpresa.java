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

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		String nombre = req.getParameter("name");
		String paramFechaApertura = req.getParameter("date");
		Date fechaApertura;

		// codigo compartido
//		Usuario usuarioExistente = (Usuario) session.getAttribute("existeUsuario");
//		if (usuarioExistente == null) {
//			return "redirect:entrada?accion=IngresarUsuario";
//		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaApertura = sdf.parse(paramFechaApertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa nuevaEmpresa = new Empresa();
		nuevaEmpresa.setNombreEmpresa(nombre);
		nuevaEmpresa.setFechaApertura(fechaApertura);

		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(nuevaEmpresa);

//		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//		req.setAttribute("empresa", nuevaEmpresa.getNombreEmpresa());
//		rd.forward(req, resp);

		return "redirect:entrada?accion=ListaEmpresas";

	}

}
