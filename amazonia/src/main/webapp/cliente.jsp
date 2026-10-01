<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>Registro de cliente</h2>

<form action="cliente/formulario" method="post">
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="nombre" name="nombre">
		</div>
	</div>
	<div class="row mb-3">
		<label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="apellidos"
				name="apellidos">
		</div>
	</div>
	<div class="row mb-3">
		<label for="nif" class="col-sm-2 col-form-label">Nif</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="nif" name="nif">
		</div>
	</div>
	<div class="mb-3">
		<div class="offeset-sm-2 col-sm">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
</form>

<%@ include file="/includes/pie.jsp"%>