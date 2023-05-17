package com.alura.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.servlet.DB;
import com.alura.gerenciador.servlet.Empresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas {
	
	public void ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DB database = new DB();	
		List<Empresa> listaEmpresas = database.getEmpresas();
					
		req.setAttribute("listaNombres", listaEmpresas);
		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(req, resp);	
		
		System.out.println("Renderizando lista de empresas");
	}

}
