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
					<small class="text-body-secondary">${producto.precio}</small>
				</p>
			</div>
		</div>
	</div>
</div>

<%@ include file="/includes/pie.jsp"%>
</body>
</html>