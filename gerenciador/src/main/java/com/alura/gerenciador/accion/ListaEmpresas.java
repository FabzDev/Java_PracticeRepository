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
	
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
		DB database = new DB();	
		List<Empresa> listaEmpresas = database.getEmpresas();
					
		req.setAttribute("listaNombres", listaEmpresas);
		
		//codigo compartido
//		Usuario usuarioExistente = (Usuario) session.getAttribute("existeUsuario");
//		System.out.println(usuarioExistente);
//		if(usuarioExistente == null) {
//			return "redirect:entrada?accion=IngresarUsuario";
//		}
		
		System.out.println("Renderizando lista de empresas");
		return "forward:listaEmpresas.jsp";
		
	}

}