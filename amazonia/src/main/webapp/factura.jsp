<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>
	<i class="bi bi-receipt"> Factura</i>
</h2>



<div class="row row-cols-md-2 mb-5">
	<div class="col">
		<h3 class="col">Nº factura: ${factura.numero}</h3>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Emisor</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">Amazonia</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">CIF:
					B98745632</h6>
				<p class="card-subtitle">C/Ubicacion n.25</p>
				<p class="card-subtitle">C.P.: 48000</p>
				<p class="card-subtitle">Bilbao</p>
			</div>
		</div>
	</div>

	<div class="col">
		<h3 class="col">Fecha: ${factura.fecha}</h3>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Factura a</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">${factura.cliente.nombre}</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">NIF:${factura.cliente.nif}</h6>
			</div>
		</div>
	</div>
</div>

<div class="table-responsive">
	<div class="card">
		<div class="card-body">
			<table class="table table-borderless">
				<caption>Factura Pedido</caption>

				<thead>
					<tr>
						<th>Nombre</th>
						<th class="text-end">Precio</th>
						<th class="text-center">Cantidad</th>
						<th class="text-end d-none d-md-table-cell">Subtotal</th>
						<th class="text-end d-none d-md-table-cell">IVA</th>
						<th class="text-end">Total</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${factura.lineas}" var="l">
						<tr class="align-middle">
							<td>${l.producto.nombre}</td>
							<td class="text-end">${l.producto.precio}</td>
							<td class="text-center">${l.cantidad}</td>
							<td class="text-end d-none d-md-table-cell">${l.subTotal}</td>
							<td class="text-end d-none d-md-table-cell">${l.iva}</td>
							<td class="text-end fw-bold">${l.total}</td>
						</tr>
					</c:forEach>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">SubTotal</td>
						<td class="text-end">${factura.subTotal}</td>
					</tr>
					<tr>
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">IVA</td>
						<td class="text-end">${factura.iva}</td>
					</tr>
					<tr class="fw-bold">
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">Total</td>
						<td class="text-end">${factura.total}</td>
					</tr>
				</tfoot>

			</table>

		</div>
	</div>
</div>

</div>
<%@ include file="/includes/pie.jsp"%>