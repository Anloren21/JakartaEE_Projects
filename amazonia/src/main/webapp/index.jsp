<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>


<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach var="p" items="${productos}">
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/id/${p.id}/400/300"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${p.nombre}</h5>
					<p class="card-text">${p.descripción}</p>
					<p class="card-text">
						<a class="btn btn-primary" href="detalle?id=${p.id}">Ver
							producto</a>
					</p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary">${p.precio} €</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/includes/pie.jsp"%>