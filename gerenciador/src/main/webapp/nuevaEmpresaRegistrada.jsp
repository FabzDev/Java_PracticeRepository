<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/listaEmpresas" var="urlListaEmpresas" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva empresa registrada</title>
</head>

<body>
	<c:if test="${not empty empresa}">
	${empresa}: Empresa registrada con exito
	</c:if>

	<c:if test="${empty empresa}">
	No se registro ninguna Empresa
	</c:if>

	<br>
	<br>

	<form action="${urlListaEmpresas}">
		<input type="text" name="name" style="display: none" /> <br> <input
			type="submit" value="Lista de empresas" />
</body>
</html>