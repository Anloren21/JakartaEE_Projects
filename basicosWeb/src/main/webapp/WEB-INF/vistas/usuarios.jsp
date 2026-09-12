<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento de Usuarios</title>
</head>
<body>
	<h1>Mantenimiento de Usuarios</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Rol</th>
				<th>OPCIONES</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${usuarios}" var="usuario"></c:forEach>
			<tr>
				<th>${usuario.id()}</th>
				<td>${usuario.nombre()}></td>
				<td>${usuario.email()}</td>
				<td>${usuario.rolNombre()}</td>
				<td><a href="usuario?id=${usuario.id()}">Editar</a> <a
					href="usuarios?borrar=${usuario.id()}">Borrar</a></td>
			</tr>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="4"></td>
				<td><a href="usuario">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>