<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>


<table class="table table-hover table-striped table-bordered">
	<caption>Listado de productos</caption>

	<thead class="table-secondary">
		<tr>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="p" items="${productos}">
			<tr>
				<th class="text-end">${p.id}</th>
				<td>${p.nombre}</td>
				<td class="text-end">${p.precio}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="/includes/pie.jsp"%>