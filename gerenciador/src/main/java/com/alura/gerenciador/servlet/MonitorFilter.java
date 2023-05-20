package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitorFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		Long bf = System.currentTimeMillis();
		
		String stringAccion = req.getParameter("accion");
		
		chain.doFilter(req, resp);
		Long af = System.currentTimeMillis();
		
		System.out.println("Tiempo de ejecución de "+ stringAccion + " ->" + (af - bf));
	}

}
