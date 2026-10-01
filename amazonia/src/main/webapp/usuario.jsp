<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>Perfil de usuario</h2>

<div class="row row-cols-md-2 mb-5">
	<div class="col">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Datos de usuario</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">${usuario.nombre}</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">${usuario.email}</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">${usuario.rol}</h6>
			</div>
		</div>
	</div>

	<div class="col">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Datos de cliente</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">${usuario.cliente.nombre}
					${usuario.cliente.apellidos}</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">NIF:
					${usuario.cliente.nif}</h6>
			</div>
		</div>
	</div>
</div>

<div class="card">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-borderless">
				<caption>Facturas</caption>

				<thead>
					<tr>
						<th>Número</th>
						<th>Fecha</th>
						<th class="text-end d-none d-md-table-cell">Subtotal</th>
						<th class="text-end d-none d-md-table-cell">IVA</th>
						<th class="text-end">Total</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${facturas}" var="f">
						<tr class="align-middle">
							<td>${f.numero}</td>
							<td>${f.fecha}</td>
							<td class="text-end d-none d-md-table-cell"><fmt:formatNumber
									type="currency" value="${f.subTotal}" /></td>
							<td class="text-end d-none d-md-table-cell"> <fmt:formatNumber
									type="currency" value="${f.iva}"/></td>
							<td class="text-end fw-bold"><fmt:formatNumber
									type="currency" value="${f.total}" /></td>
							<td><a class="btn btn-primary" href="factura?id=${f.id}">Ver
									factura</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>
</div>

<%@ include file="/includes/pie.jsp"%>