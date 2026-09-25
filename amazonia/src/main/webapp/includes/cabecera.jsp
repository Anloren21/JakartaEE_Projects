<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!doctype html>
<html lang="es" class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Amazonia | Tienda Online</title>

<base href="${pageContext.request.contextPath}/">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
</head>
<body class="h-100 d-flex flex-column justify-content-between">
	<nav class="navbar navbar-expand-lg bg-dark sticky-top"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">Amazonia | Tienda Online</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active" href="carrito"><i
							class="bi bi-cart"></i>&nbsp;CARRITO</a></li>

					<c:if test="${usuario.rol == 'ADMIN' }">
						<li class="nav-item"><a class="nav-link active"
							href="admin/listado">Administración</a></li>
					</c:if>
					<c:if test="${usuario != null}">
						<li class="navbar-text"><i class="bi bi-person-fill"></i>&nbsp;
							${usuario.nombre}&nbsp;${usuario.rol}</li>
					</c:if>

					<c:if test="${usuario == null}">
						<li class="nav-item"><a class="nav-link" href="login"><i
								class="bi bi-box-arrow-in-right"></i></a></li>
					</c:if>

					<c:if test="${usuario != null}">
						<li class="nav-item"><a class="nav-link" href="logout"><i
								class="bi bi-box-arrow-right"></i></a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>

	<%="<main class='container my-5'>"%>