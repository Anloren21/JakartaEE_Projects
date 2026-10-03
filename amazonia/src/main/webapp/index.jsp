
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="/includes/cabecera.jsp"%>


<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach var="p" items="${productos}">
		<div class="col">
			<div class="card h-100">
				<img src="fotos/${p.id}.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${p.nombre}</h5>
					<p class="card-text">${p.descripción}</p>
					<p class="card-text">
						<a class="btn btn-primary" href="detalle?id=${p.id}">Ver
							producto</a>
					</p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary"> <fmt:formatNumber
							type="currency" value="${p.precio}" /></small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<nav aria-label="Page navigation">
	<ul class="pagination justify-content-center">
		<!-- Ir al Inicio-->
		<li class="page-item disabled"><a class="page-link" href="#"
			aria-label="Previous"> <i class="bi bi-chevron-bar-left"></i>
		</a></li>
		
		<!-- Anterior -->
		<li class="page-item disabled"><a class="page-link" href="#"
			aria-label="Anterior"> <i class="bi bi-chevron-left"></i>
		</a></li>
		
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		
		<!-- Siguiente -->
		<li class="page-item"><a class="page-link" href="#"
			aria-label="Next">  <i class="bi bi-chevron-right"></i>
		</a></li>

		<!-- Ir al final-->
		<li class="page-item"><a class="page-link" href="#"
			aria-label="Último"> <i class="bi bi-chevron-bar-right"></i>
		</a></li>
	</ul>
</nav>

<%@ include file="/includes/pie.jsp"%>