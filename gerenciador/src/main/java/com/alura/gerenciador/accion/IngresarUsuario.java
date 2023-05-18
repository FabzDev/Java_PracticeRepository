package com.alura.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class IngresarUsuario implements Accion {

	@Override
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usuario = req.getParameter("usuario");
		String contrasena = req.getParameter("contrasena");

		DB db = new DB();
		List<Usuario> listaUsuarios = db.getUsuarios();

		Usuario existeUsuario = db.encontrarUsuario(usuario);
		
		if (existeUsuario != null) {
			System.out.println("Usuario validado");
			HttpSession session = req.getSession();
			System.out.println(session.getId());
			session.setAttribute("user", existeUsuario);
			return "redirect:entrada?accion=ListaEmpresas";

		} else {
			System.out.println("Usuario no validado");
			return "redirect:entrada?accion=IngresarUsuarioForm";
		}
	}

}
//70907