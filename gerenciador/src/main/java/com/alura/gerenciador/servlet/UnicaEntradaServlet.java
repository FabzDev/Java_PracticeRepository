package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.accion.Accion;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
//		System.out.println(session.getId());

		String paramAccion = request.getParameter("accion");
		String nombreClase = "com.alura.gerenciador.accion." + paramAccion;
		String result;

		try {

			Class clase = Class.forName(nombreClase);
			Object obj = clase.newInstance();
			Accion accion = (Accion) obj;
			System.out.println(paramAccion);
			if (paramAccion == "IngresarUsuarioForm" || paramAccion == "IngresarUsuario") {
				System.out.println("Chanfle");
				result = accion.ejecutar(request, response, session);
			} else {
				Usuario usuarioExistente = (Usuario) session.getAttribute("existeUsuario");
				if (usuarioExistente == null) {
					System.out.println("Chanfleson");

					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/formIngresarUsuario.jsp");
					rd.forward(request, response);
					return;
				}
			}
			

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

//		if (paramAccion.equals("ListaEmpresas")) {
//			ListaEmpresas accionLista = new ListaEmpresas();
//			result = accionLista.ejecutar(request, response);
//		} else if (paramAccion.equals("ModificarEmpresa")) {
//			ModificarEmpresa accionModificar = new ModificarEmpresa();
//			result = accionModificar.ejecutar(request, response);
//		} else if (paramAccion.equals("EliminarEmpresa")) {
//			EliminarEmpresa accionEliminar = new EliminarEmpresa();
//			result = accionEliminar.ejecutar(request, response);
//		} else if(paramAccion.equals("ModificarDB")) {
//			ModificarEmpresaEnDB accionModificarDB = new ModificarEmpresaEnDB();
//			result = accionModificarDB.ejecutar(request, response);
//		} else if(paramAccion.equals("NuevaEmpresa")) {
//			NuevaEmpresa accionNuevaEmpresa = new NuevaEmpresa();
//			result = accionNuevaEmpresa.ejecutar(request, response);
//		} else if(paramAccion.equals("NuevaEmpresaForm")) {
//			NuevaEmpresaForm accionNuevaEmpresaForm = new NuevaEmpresaForm();
//			result = accionNuevaEmpresaForm.ejecutar(request, response);
//		}

	}
}
