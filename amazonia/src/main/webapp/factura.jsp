<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>
	<i class="bi bi-receipt"> Factura</i>
</h2>

<div class="d-flex justify-content-between">
	<h3>Nº factura: 2026-0001</h3>
	<h3>Fecha: 26/09/2026</h3>
</div>


<div class="row row-cols-md-2 mb-5">
	<div class="col">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Emisor:</h5>
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
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Factura a:</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">Angie Rojas</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">NIF:
					98745632X</h6>
				<p class="card-subtitle">C/Ubicacion n.25</p>
				<p class="card-subtitle">C.P.: 48000</p>
				<p class="card-subtitle">Bilbao</p>
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
					<tr class="align-middle">
						<td>Portátil</td>
						<td class="text-end">1.234,56 €</td>
						<td class="text-center">2</td>
						<td class="text-end d-none d-md-table-cell">2.000 €</td>
						<td class="text-end d-none d-md-table-cell">420,00 €</td>
						<td class="text-end fw-bold">2.420,00 €</td>
					</tr>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">SubTotal</td>
						<td class="text-end">2.000,00 €</td>
					</tr>
					<tr>
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">IVA</td>
						<td class="text-end">420,00 €</td>
					</tr>
					<tr class="fw-bold">
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">Total</td>
						<td class="text-end">2.420,00 €</td>
					</tr>
				</tfoot>

			</table>

		</div>
	</div>
</div>

</div>
<%@ include file="/includes/pie.jsp"%>