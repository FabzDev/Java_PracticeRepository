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

public class ModificarDB implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
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

//		Empresa nuevaEmpresa = new Empresa();
//		nuevaEmpresa.setNombreEmpresa(nombre);
//		nuevaEmpresa.setFechaApertura(fechaApertura);

		DB baseDeDatos = new DB();
		Empresa empresaParaActualizar = baseDeDatos.getEmpresa(id);
		empresaParaActualizar.setNombreEmpresa(nombre);
		empresaParaActualizar.setFechaApertura(fechaApertura);

//		request.setAttribute("empresaObjeto", empresaParaUpdate);
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		rd.forward(request, response);

		return "redirect:entrada?accion=ListaEmpresas";

	}
}
