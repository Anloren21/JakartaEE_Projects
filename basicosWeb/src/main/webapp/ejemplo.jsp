<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo básico de JSP</title>
</head>
<body>
	<p>
		Hoy estamos a
		<%=java.time.LocalDateTime.now()%></p>
	<ul>
		<%
		for (int i = 1; i <= 3; i++) {
		%>
		<li><%=i %></li>
		<%
		}
		%>
	</ul>
</body>
</html> 