package com.alura.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public interface Accion {
	public String ejecutar(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException;
}
