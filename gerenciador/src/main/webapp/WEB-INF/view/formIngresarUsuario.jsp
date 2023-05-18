<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?accion=IngresarUsuario" var="urlIngresarUsuario" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo usuario</title>
</head>
<body>

	<form action="${urlIngresarUsuario}" method="post">

		<h2>Usuario:</h2>

		<input type="text" name="usuario" />

		<h3>Contraseña:</h3>
		<input type="password" name="contrasena" /> <br> <br> <input
			type="submit" />

	</form>

</body>
</html>