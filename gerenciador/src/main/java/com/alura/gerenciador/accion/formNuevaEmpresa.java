package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class formNuevaEmpresa implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {

		System.out.println("Controller Form Nueva Empresa");
		
		return "forward:formNuevaEmpresa.jsp";
	}
}
