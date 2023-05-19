package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class NuevaEmpresaForm implements Accion {

	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {

		// codigo compartido
//		Usuario usuarioExistente = (Usuario) session.getAttribute("existeUsuario");
//		if (usuarioExistente == null) {
//			return "redirect:entrada?accion=IngresarUsuario";
//		}

		return "forward:formNuevaEmpresa.jsp";
	}
}
