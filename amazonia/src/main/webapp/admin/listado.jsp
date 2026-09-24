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
			<th>OPCIONES</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="p" items="${productos}">
			<tr class="align-middle">
				<th class="text-end">${p.id}</th>
				<td>${p.nombre}</td>
				<td class="text-end">${p.precio}</td>
				<td><a class="btn btn-sm btn-primary" href="#"><i
						class="bi bi-pencil-fill"></i></a> <a class="btn btn-sm btn-danger"
					href="#"><i class="bi bi-trash-fill"></i></a></td>
			</tr>
		</c:forEach>
	</tbody>

	<tfoot class="table-secondary">
		<tr>
			<td colspan="3"></td>
			<td><a class="btn btn-sm btn-primary" href="#"><i
					class="bi bi-plus-lg"></i></a></td>
		</tr>
	</tfoot>
</table>
<%@ include file="/includes/pie.jsp"%>