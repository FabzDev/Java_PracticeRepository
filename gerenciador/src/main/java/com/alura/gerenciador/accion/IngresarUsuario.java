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
		
		System.out.println("Controller Ingresar Usuario");
		
		String usuario = req.getParameter("usuario");
		String contrasena = req.getParameter("contrasena");

		DB db = new DB();
		Usuario usuarioDB = db.encontrarUsuario(usuario);

		if (usuarioDB != null) {
			if (usuarioDB.getContrasena().equals(contrasena)) {
				System.out.println("Usuario validado");
				session.setAttribute("usuarioDB", usuarioDB);
				return "redirect:entrada?accion=ListaEmpresas";
			}
			System.out.println("Contrasena incorrecta");
			return "redirect:entrada?accion=formIngresarUsuario";
		}
		System.out.println("El usuario ingresado no existe");
		return "redirect:entrada?accion=formIngresarUsuario";
	}
}