<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?accion=NuevaEmpresa"	var="urlNuevaEmpresaRegistrada" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingresar nueva Empresa</title>
</head>
<body>

	<form action="${urlNuevaEmpresaRegistrada}" method="post">

		<h2>Nueva Empresa</h2>

		<input type="text" name="nombre" />

		<h3>Fecha de apertura</h3>
		<input type="text" name="fecha" /> <br> <br> <input
			type="submit" />

	</form>

</body>
</html>