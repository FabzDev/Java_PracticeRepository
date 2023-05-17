package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.accion.EliminarEmpresa;
import com.alura.gerenciador.accion.ListaEmpresas;
import com.alura.gerenciador.accion.ModificarEmpresa;
import com.alura.gerenciador.accion.ModificarEmpresaEnDB;
import com.alura.gerenciador.accion.NuevaEmpresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAccion = request.getParameter("accion");
		
		
		if (paramAccion.equals("ListaEmpresas")) {
			ListaEmpresas accionLista = new ListaEmpresas();
			accionLista.ejecutar(request, response);
		} else if (paramAccion.equals("ModificarEmpresa")) {
			ModificarEmpresa accionModificar = new ModificarEmpresa();
			accionModificar.ejecutar(request, response);
		} else if (paramAccion.equals("EliminarEmpresa")) {
			EliminarEmpresa accionEliminar = new EliminarEmpresa();
			accionEliminar.ejecutar(request, response);
		} else if(paramAccion.equals("ModificarDB")) {
			ModificarEmpresaEnDB accionModificarDB = new ModificarEmpresaEnDB();
			accionModificarDB.ejecutar(request, response);
		} else if(paramAccion.equals("NuevaEmpresa")) {
			NuevaEmpresa accionNuevaEmpresa = new NuevaEmpresa();
			accionNuevaEmpresa.ejecutar(request, response);
		}
	}

}
