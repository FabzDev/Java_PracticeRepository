<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?accion=ModificarEmpresaEnDB" var="urlNuevaEmpresaRegistrada" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Empresa</title>
</head>
<body>

	<form action="${urlNuevaEmpresaRegistrada}" method="post">

		<h2>Nuevo nombre de Empresa:</h2>

		<input type="text" name="nombreMod" value="${empresaObjeto.nombreEmpresa}" />

		<h3>Nueva Fecha de apertura:</h3>
		<input type="text" name="fechaMod"
			value="<fmt:formatDate
					value="${empresaObjeto.fechaApertura}" pattern="dd/MM/yyyy" />" />
		<input type="hidden" name="idMod" value="${empresaObjeto.id}" /> <input
			type="submit" />

	</form>

</body>
</html>