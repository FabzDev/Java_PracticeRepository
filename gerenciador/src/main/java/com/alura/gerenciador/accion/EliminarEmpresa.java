package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.servlet.DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarEmpresa {

	public void ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId  = req.getParameter("id"); 
		Integer id = Integer.valueOf(paramId);
		DB dataBaseParaDelete = new DB();
		dataBaseParaDelete.eliminarEmpresa(dataBaseParaDelete.getEmpresa(id));
		
		
		resp.sendRedirect("listaEmpresas");
//		RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//		rd.forward(req, resp);
		
	}
}
