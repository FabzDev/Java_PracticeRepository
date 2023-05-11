<%@page import="com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Java Standard TagLib</title>
	</head>
	<body>
	<h2>Lista de empresas:</h2>
		<ul>
			
			<c:forEach items="${listaNombres}" var="empresa">
			<li> ${empresa.nombreEmpresa} </li>
			</c:forEach>
			
		</ul>
	</body>
</html>