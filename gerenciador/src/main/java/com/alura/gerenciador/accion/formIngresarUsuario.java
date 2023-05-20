package com.alura.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class formIngresarUsuario implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Controller Form Ingresar Usuario");
		
		return "forward:formIngresarUsuario.jsp";
	}	
}
