package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EliminarEmpresa implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		DB dataBaseParaDelete = new DB();
		dataBaseParaDelete.eliminarEmpresa(dataBaseParaDelete.getEmpresa(id));

		// codigo compartido
//		Usuario usuarioExistente = (Usuario) session.getAttribute("existeUsuario");
//		if (usuarioExistente == null) {
//			return "redirect:entrada?accion=IngresarUsuario";
//		}
		System.out.println("Eliminando empresa #" + id);
		return "redirect:entrada?accion=ListaEmpresas";
	}
}

//RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//rd.forward(req, resp);