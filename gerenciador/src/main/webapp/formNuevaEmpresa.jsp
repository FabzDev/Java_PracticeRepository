<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/nuevaEmpresa" var="urlNuevaEmpresaRegistrada" />

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	

	
	<form action="${urlNuevaEmpresaRegistrada}" method="post">

		<h2>Nueva Empresa:</h2>
		<input type="text" name="name" />
		<a href="/gerenciador/listaEmpresas.jsp">delete</a>
		
		<h3>Fecha de apertura</h3>
		<input type="text" name="date" /> <br> 
		
		<br>
		
		<input type="submit" />

	</form>
	
	

</body>
</html>