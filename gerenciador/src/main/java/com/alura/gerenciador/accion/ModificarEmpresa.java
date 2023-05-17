package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.servlet.DB;
import com.alura.gerenciador.servlet.Empresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarEmpresa {

	public void ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		DB dataBaseParaUpdate = new DB();
		Empresa empresaParaUpdate = dataBaseParaUpdate.getEmpresa(id);
//	dataBaseParaUpdate.eliminarEmpresa(dataBaseParaUpdate.getEmpresa(id));
//	resp.sendRedirect("/gerenciador/formNuevaEmpresa.jsp");

		req.setAttribute("empresaObjeto", empresaParaUpdate);
		RequestDispatcher rd = req.getRequestDispatcher("/modificarEmpresa.jsp");
		rd.forward(req, resp);
		
		System.out.println("Redirigiendo a modificarEmpresa.jsp");

	}
}