<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="https://picsum.photos/400/400"
				class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${producto.nombre}</h5>
				<p class="card-text">${producto.descripción}</p>
				<p class="card-text">
					<small class="text-body-secondary"> <fmt:formatNumber
							type="currency" value="${producto.precio}" />
					</small>
				</p>

				<form class="d-flex" action="carrito/anadir">
					<input type="hidden" name="id" value="${producto.id}">
					<button class="me-3 btn btn-primary" type="submit">Añadir
						a carrito</button>

					<span class="input-group" style="width: auto">
						<button class="btn btn-outline-secondary" type="button">
							<i class="bi bi-dash"></i>
						</button> <input name="cantidad" type="text" pattern="\d+" class="form-control text-center"
						style="max-width: 3rem" value="1">
						<button class="btn btn-outline-secondary" type="button">
							<i class="bi bi-plus-lg"></i>
						</button>
					</span>
				</form>

			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

</script>

<%@ include file="/includes/pie.jsp"%>
</body>
</html>