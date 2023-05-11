<%@page import="com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<h2>Lista de empresas:</h2>
		<ul>
			<% 
			List<Empresa> listaEmpresas = (List<Empresa>)request.getAttribute("listaNombres");
			for (Empresa empresa : listaEmpresas) { %>
			<li> <%=empresa.getNombreEmpresa() %> </li>
			<% } %>
		</ul>
	</body>
</html>