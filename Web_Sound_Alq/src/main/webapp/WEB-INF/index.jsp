<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Sound Online</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/app.js" defer></script>
</head>

<body>
<header>
	<h1>Sound Online</h1>
	<p>Gesti&oacute;n de alquiler de equipos</p>
</header>

<main>

<section class="tarjeta">
	<div class="cabecera-seccion">
		<h2>Equipos disponibles</h2>
		<button onclick="cargarEquipos()">Actualizar</button>
	</div>

	<table>
		<thead>
			<tr>
				<th>ID</th><th>Modelo</th><th>Categor&iacute;a</th><th>Stock</th><th>Estado</th>
			</tr>
		</thead>
		<tbody id="tablaEquipos"></tbody>
	</table>
</section>

<div class="acciones">

<section class="tarjeta">
	<h2>Realizar alquiler</h2>

	<label>Equipo</label>
	<select id="alquilerEquipo">
		<option value="">Selecciona un equipo</option>
	</select>

	<label>Cantidad</label>
	<input type="number" id="alquilerCantidad" min="1">

	<label>Fecha prevista de devoluci&oacute;n</label>
	<input type="date" id="fechaDevolucion" readonly>

	<button onclick="realizarAlquiler()">Alquilar</button>
</section>

<section class="tarjeta">
	<h2>Gesti&oacute;n de equipos</h2>
	<button type="button" onclick="location.href='alta.jsp'">A&ntilde;adir equipo</button>
</section>

</div>

<section class="tarjeta">
	<div class="cabecera-seccion">
		<h2>Alquileres</h2>
		<button onclick="cargarAlquileres()">Actualizar</button>
	</div>

	<table>
		<thead>
			<tr>
				<th>ID</th><th>Equipo</th><th>Cantidad</th><th>Alquiler</th>
				<th>Prevista</th><th>Devoluci&oacute;n</th><th>Estado</th><th>Acci&oacute;n</th>
			</tr>
		</thead>
		<tbody id="tablaAlquileres"></tbody>
	</table>
</section>

<div id="mensaje" class="mensaje"></div>

</main>
</body>
</html>