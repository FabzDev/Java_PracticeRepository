
<% 
String nombre = (String) request.getAttribute("empresa");
System.out.println(nombre);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva empresa registrada</title>
</head>

<body>
	<%=nombre%>
	: Empresa registrada con exito
	<br>
	<br>

	<form action="/gerenciador/listaEmpresas">
		<input type="text" name="name" style="display: none"/> <br> <input type="submit" value="Lista de empresas"/>
</body>
</html>