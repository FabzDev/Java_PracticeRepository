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
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {

		String usuario = req.getParameter("usuario");
		String contrasena = req.getParameter("contrasena");

		DB db = new DB();
		System.out.println(usuario);
		System.out.println(contrasena);
		Usuario existeUsuario2 = db.encontrarUsuario(usuario);
		System.out.println(existeUsuario2);
		if (existeUsuario2 != null) {
			System.out.println("not null");

			if (existeUsuario2.getContrasena().equals(contrasena)) {
				System.out.println("Usuario validado");
				session.setAttribute("existeUsuario", existeUsuario2);
				return "redirect:entrada?accion=ListaEmpresas";
			} else {
				System.out.println("Usuario no validado");
				return "redirect:entrada?accion=IngresarUsuarioForm";
			}
		} else {
			System.out.println("Usuario no validado");
			return "redirect:entrada?accion=IngresarUsuarioForm";
		}
	}
}