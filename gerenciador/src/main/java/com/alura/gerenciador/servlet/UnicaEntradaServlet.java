package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAccion = request.getParameter("accion");
		
		if (paramAccion.equals("ListaEmpresas")) {
			

			
			
			
		}else if(paramAccion.equals("MostrarEmpresa")) {
			System.out.println("MostrarEmpresa ejecutado");
		} else if (paramAccion.equals("EliminarEmpresa")){
			System.out.println("EliminarEmpresa ejecutado");
		}
	}

}
