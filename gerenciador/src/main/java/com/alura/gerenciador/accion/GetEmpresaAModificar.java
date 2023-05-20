package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetEmpresaAModificar implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Controller GetEmpresaAModificar");
		
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		DB db = new DB();
		Empresa empresaDB = db.getEmpresa(id);

		req.setAttribute("empresaObjeto", empresaDB);

		return "forward:formModificarEmpresa.jsp";
	}
}