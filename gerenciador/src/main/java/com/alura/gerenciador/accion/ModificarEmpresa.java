package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarEmpresa {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		DB dataBaseParaUpdate = new DB();
		Empresa empresaParaUpdate = dataBaseParaUpdate.getEmpresa(id);
//	dataBaseParaUpdate.eliminarEmpresa(dataBaseParaUpdate.getEmpresa(id));
//	resp.sendRedirect("/gerenciador/formNuevaEmpresa.jsp");

		req.setAttribute("empresaObjeto", empresaParaUpdate);
		
		System.out.println("Redirigiendo a modificarEmpresa.jsp");

		return "forward:/modificarEmpresa.jsp";
	}
}