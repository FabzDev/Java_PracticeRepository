<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/nuevaEmpresa" var="urlNuevaEmpresaRegistrada" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificando empresa</title>
</head>
<body>

	<form action="${urlNuevaEmpresaRegistrada}" method="post">

		<h2>Nuevo nombre de Empresa:</h2>

		<input type="text" name="name" value="${empresaObjeto.nombreEmpresa}" />

		<h3>Nueva Fecha de apertura:</h3>
		<input type="text" name="date" value="<fmt:formatDate
					value="${empresaObjeto.fechaApertura}" pattern="dd/MM/yyyy" />" />

		<input type="submit" />

	</form>

</body>
</html>