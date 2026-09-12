<%@page import="dto.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento de Usuarios</title>
</head>
<body>
	<h1>Mantenimiento de Usuarios</h1>

	<form action="usuario" method="post">
		<input name="id" placeholder="Id" value="<%=usuario.id()%>"> <input
			name="nombre" placeholder="Nombre" value="<%=usuario.nombre()%>"> <input
			name="email" placeholder="Email" value="<%=usuario.email()%>"> <input
			type="password" name="password" placeholder="Contraseña">

		<button>Guardar</button>
	</form>
</body>
</html>