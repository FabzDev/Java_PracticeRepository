package com.alura.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListaEmpresas implements Accion{
	
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DB database = new DB();	
		List<Empresa> listaEmpresas = database.getEmpresas();
					
		req.setAttribute("listaNombres", listaEmpresas);
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null) {
			return "redirect:entrada?accion=IngresarUsuario";
		}
		
		System.out.println("Renderizando lista de empresas");
		
		return "forward:listaEmpresas.jsp";
		
	}

}