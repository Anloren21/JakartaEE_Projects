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

<%@ include file="/includes/pie.jsp"%>