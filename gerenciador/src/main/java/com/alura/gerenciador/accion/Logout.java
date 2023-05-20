package com.alura.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout implements Accion {

	@Override
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		
		System.out.println("Controller Logout");
		
		session.invalidate();
		
		return "forward:formIngresarUsuario.jsp";
	}

}
