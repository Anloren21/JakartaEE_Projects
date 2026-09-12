<%@page import="dto.Usuario"%>
<%@page import="accesodatos.UsuariosCrud"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<tr>
				<%
				@SuppressWarnings("unchecked")
				ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");

				for (Usuario usuario : usuarios) {
				%>
				<th><%=usuario.id()%></th>
				<td><%=usuario.nombre()%></td>
				<td><%=usuario.email()%></td>
				<td><%=usuario.rolNombre()%></td>
				<td><a href="usuario.jsp?id=<%=usuario.id()%>">Editar</a> <a
					href="usuarios.jsp?borrar=<%=usuario.id()%>">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="4"></td>
				<td><a href="usuario.jsp">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>