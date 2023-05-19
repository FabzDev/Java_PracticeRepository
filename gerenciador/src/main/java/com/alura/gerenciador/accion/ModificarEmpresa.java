package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ModificarEmpresa implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		DB dataBaseParaUpdate = new DB();
		Empresa empresaParaUpdate = dataBaseParaUpdate.getEmpresa(id);
//	dataBaseParaUpdate.eliminarEmpresa(dataBaseParaUpdate.getEmpresa(id));
//	resp.sendRedirect("/gerenciador/formNuevaEmpresa.jsp");

		// codigo compartido
//		Usuario usuarioExistente = (Usuario) session.getAttribute("existeUsuario");
//		if (usuarioExistente == null) {
//			return "redirect:entrada?accion=IngresarUsuario";
//		}

		req.setAttribute("empresaObjeto", empresaParaUpdate);

		System.out.println("Redirigiendo a modificarEmpresa.jsp");

		return "forward:modificarEmpresa.jsp";
	}
}