package com.alura.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas {
	
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DB database = new DB();	
		List<Empresa> listaEmpresas = database.getEmpresas();
					
		req.setAttribute("listaNombres", listaEmpresas);
			
		
		System.out.println("Renderizando lista de empresas");
		
		return "forward:/listaEmpresas.jsp";
		
	}

}