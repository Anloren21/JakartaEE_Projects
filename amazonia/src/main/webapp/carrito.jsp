<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>
	<i class="bi bi-cart"></i>
</h2>

<table class="table table-hover table-striped table-bordered">
	<caption>Carrito</caption>

	<thead class="table-secondary">
		<tr>
			<th></th>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
			<th class="text-end">Cantidad</th>
			<th class="text-end">Total sin IVA</th>
			<th class="text-end">IVA</th>
			<th class="text-end">Total</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${carrito.lineas}" var="linea">
			<tr class="align-middle">
				<td><a href="carrito/borrar?id=${linea.producto.id}"><i class="text-danger bi bi-trash"></i></a></td>
				<td>${linea.producto.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${linea.producto.precio}" /></td>
				<td class="text-end">${linea.cantidad}</td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${linea.subTotal}" /></td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${linea.iva}" /></td>
				<td class="text-end fw-bold"><fmt:formatNumber type="currency"
						value="${linea.total}" /></td>
			</tr>
		</c:forEach>
	</tbody>

	<tfoot class="table-secondary">
		<tr>
			<td colspan="5"></td>
			<td class="text-end">SubTotal</td>
			<td class="text-end"><fmt:formatNumber type="currency"
					value="${carrito.subTotal}" /></td>
		</tr>
		<tr>
			<td colspan="5"></td>
			<td class="text-end">IVA</td>
			<td class="text-end"><fmt:formatNumber type="currency"
					value="${carrito.iva}" /></td>
		</tr>
		<tr class="fw-bold">
			<td colspan="5"></td>
			<td class="text-end">Total</td>
			<td class="text-end"><fmt:formatNumber type="currency"
					value="${carrito.total}" /></td>
		</tr>
	</tfoot>

</table>
<%@ include file="/includes/pie.jsp"%>