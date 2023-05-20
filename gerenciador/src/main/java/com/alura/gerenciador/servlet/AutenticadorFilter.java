package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class AutenticadorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();
		System.out.println("\n" + session);
		
		Usuario usuarioLogin = (Usuario) session.getAttribute("usuarioDB");
		String stringAccion = request.getParameter("accion");
		
		
		if (stringAccion.equals("formIngresarUsuario") || stringAccion.equals("IngresarUsuario") || usuarioLogin != null){
			System.out.println(1);
			chain.doFilter(servletRequest, servletResponse);
		} else {
			System.out.println(2);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/formIngresarUsuario.jsp");
			rd.forward(servletRequest, servletResponse);
			return;
		}
		
	}

}
