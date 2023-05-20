package com.alura.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListaEmpresas implements Accion{
	
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Controller Lista Empresas");
		
		DB database = new DB();	
		List<Empresa> listaEmpresas = database.getEmpresas();					
		req.setAttribute("listaEmpresas", listaEmpresas);
		
		return "forward:listaEmpresas.jsp";
	}

}