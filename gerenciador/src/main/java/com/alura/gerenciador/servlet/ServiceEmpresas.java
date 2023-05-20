package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresas")
 public class ServiceEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Empresa> empresas = new DB().getEmpresas();
		
		String header = request.getHeader("Accept");
		if (header.contains("json")) {
			Gson gson = new Gson();
			String empresasJson = gson.toJson(empresas);
			
			response.setContentType("Application/json");
			response.getWriter().print(empresasJson);
		} else if (header.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("Empresa", Empresa.class);
			String empresasXML = xstream.toXML(empresas);
			
			response.setContentType("Application/xml");
			response.getWriter().print(empresasXML);
		} else {
			response.setContentType("Application/json");
			response.getWriter().print("{'message': 'No content'}");
		}
		
		
		
	}

}
