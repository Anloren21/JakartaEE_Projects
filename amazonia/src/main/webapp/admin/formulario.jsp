<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>


<form action="admin/formulario" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm">
			<input type="number" class="form-control" id="id" name="id"
				value="${producto.id }">
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm">
			<input type="text" class="form-control ${errores.nombre != null ? 'is-invalid' : ''}" id="nombre" name="nombre"
				value="${producto.nombre }">
			<div class="invalid-feedback">${errores.nombre}</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm">
			<input type="number" step=".02" class="form-control ${errores.precio != null ? 'is-invalid' : ''}" id="precio"
				name="precio" value="${producto.precio }">
			<div class="invalid-feedback">${errores.precio}</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="descripción" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm">
			<textarea class="form-control" id="descripción" name="descripción">${producto.descripción }</textarea>
		</div>
	</div>

	<div class="row mb-3">
		<div class="offset-sm-2 copl-sm">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>

</form>

<%@ include file="/includes/pie.jsp"%>