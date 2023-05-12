<%@page import="com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard TagLib</title>
</head>
<body>
	<c:if test="${not empty empresa}">
	${empresa}: Empresa registrada con exito
	</c:if>

	<c:if test="${empty empresa}">
	No se registro ninguna Empresa
	</c:if>

	<br>

	<h2>Lista de empresas:</h2>
	<ul>

		<c:forEach items="${listaNombres}" var="empresa">
			<li>${empresa.nombreEmpresa} - <fmt:formatDate
					value="${empresa.fechaApertura}" pattern="dd/MM/yyyy" /> <a
				href="/gerenciador/borrarEmpresa?id=${empresa.id}">delete</a></li>
		</c:forEach>

	</ul>
</body>
</html>