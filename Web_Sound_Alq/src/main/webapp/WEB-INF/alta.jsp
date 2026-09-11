<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Alta de equipo | Sound Online</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/alta.js" defer></script>
</head>
<body>

<header><h1>Nuevo equipo</h1></header>

<main>
<section class="tarjeta">
	<label>Modelo</label>
	<input id="modelo" type="text" required>

	<label>Stock</label>
	<input id="stock" type="number" min="0" required>

	<label>Categor&iacute;a</label>
	<select id="categoria"></select>

	<button onclick="guardar()">Guardar equipo</button>
	<button type="button" onclick="location.href='index.jsp'">Volver Inicio</button>

	<div id="mensaje" class="mensaje"></div>
</section>
</main>

</body>
</html>