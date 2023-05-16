package com.alura.gerenciador.accion;

import java.util.List;

import com.alura.gerenciador.servlet.DB;
import com.alura.gerenciador.servlet.Empresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public void ListaEmpresas(HttpServletRequest req, HttpServletResponse resp) {
	DB database = new DB();	
	List<Empresa> listaEmpresas = database.getEmpresas();
				
	req.setAttribute("listaNombres", listaEmpresas);
	RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
	rd.forward(req, resp);

}}
