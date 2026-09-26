<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>
	<i class="bi bi-cart"></i>
</h2>

<div class="table-responsive">
	<table class="table table-hover table-striped table-bordered">
		<caption>Carrito</caption>

		<thead class="table-secondary">
			<tr>
				<th></th>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
				<th class="text-center">Cantidad</th>
				<th class="text-end d-none d-md-table-cell">Subtotal</th>
				<th class="text-end d-none d-md-table-cell">IVA</th>
				<th class="text-end">Total</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${carrito.lineas}" var="linea">
				<tr class="align-middle">
					<td><a href="carrito/borrar?id=${linea.producto.id}"><i
							class="text-danger bi bi-trash"></i></a></td>
					<td>${linea.producto.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${linea.producto.precio}" /></td>
					<td class="text-end"><span class="input-group">
							<button id="menos" class="btn btn-outline-secondary"
								type="button">
								<i class="bi bi-dash"></i>
							</button> <input id="cantidad" name="cantidad" type="text" pattern="\d+"
							class="form-control text-center" style="max-width: 3rem"
							value="${linea.cantidad}">
							<button id="mas" class="btn btn-outline-secondary" type="button">
								<i class="bi bi-plus-lg"></i>
							</button>
					</span></td>
					<td class="text-end d-none d-md-table-cell"><fmt:formatNumber type="currency"
							value="${linea.subTotal}" /></td>
					<td class="text-end d-none d-md-table-cell"><fmt:formatNumber type="currency"
							value="${linea.iva}" /></td>
					<td class="text-end fw-bold"><fmt:formatNumber type="currency"
							value="${linea.total}" /></td>
				</tr>
			</c:forEach>
		</tbody>

		<tfoot class="table-secondary">
			<tr>
				<td colspan="3"></td>
				<td class="d-none d-md-table-cell"></td>
				<td class="d-none d-md-table-cell"></td>
				<td class="text-end">SubTotal</td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${carrito.subTotal}" /></td>
			</tr>
			<tr>
				<td colspan="3"></td>
				<td class="d-none d-md-table-cell"></td>
				<td class="d-none d-md-table-cell"></td>
				<td class="text-end">IVA</td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${carrito.iva}" /></td>
			</tr>
			<tr class="fw-bold">
				<td colspan="3"></td>
				<td class="d-none d-md-table-cell"></td>
				<td class="d-none d-md-table-cell"></td>
				<td class="text-end">Total</td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${carrito.total}" /></td>
			</tr>
		</tfoot>

	</table>
</div>
<%@ include file="/includes/pie.jsp"%>