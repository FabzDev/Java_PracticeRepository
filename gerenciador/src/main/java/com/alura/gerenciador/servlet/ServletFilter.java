package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.accion.Accion;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ServletFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		System.out.println("\n" + session);
		
		Usuario usuarioLogin = (Usuario) session.getAttribute("usuarioDB");
		String stringAccion = request.getParameter("accion");
		
		//here
		String nombreClase = "com.alura.gerenciador.accion." + stringAccion;
		String result = "";

		try {
			Class clase = Class.forName(nombreClase);
			Object obj = clase.newInstance();
			Accion accion = (Accion) obj;

			result = accion.ejecutar(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoDireccion = result.split(":");

		if (tipoDireccion[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoDireccion[1]);
			rd.forward(request, response);
		} else if (tipoDireccion[0].equals("redirect")) {
			response.sendRedirect(tipoDireccion[1]);
		}
		
		
	}

}
