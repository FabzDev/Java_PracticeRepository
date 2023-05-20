package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EliminarEmpresa implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Controller Eliminar Empresa");
		
		String stringId = req.getParameter("id");
		Integer id = Integer.valueOf(stringId);
		
		DB db = new DB();
		db.eliminarEmpresa(db.getEmpresa(id));

		System.out.println("Eliminando empresa #" + id);
		
		return "redirect:entrada?accion=ListaEmpresas";
	}
}

//RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//rd.forward(req, resp);