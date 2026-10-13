const URL = 'api/v1/productos';

function euro(cantidad){
    const fmt = new Intl.NumberFormat('es-ES', {
        style: 'currency',
        currency: 'EUR',
        minimumFractionDigits: 2,
		useGrouping: true
    });

	return fmt.format(cantidad);
}

window.addEventListener('DOMContentLoaded', async () => {
    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    const fila = document.querySelector('#listado  .row');

    for (const p of productos) {
        const div = document.createElement('div');
		div.className = 'col';
        div.innerHTML = `
			<div class="col">
				<div class="card h-100">
					<img src="fotos/${p.id}.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${p.nombre}</h5>
						<p class="card-text">${p.descripción ?? ''}</p>
						<p class="card-text">
							<a class="btn btn-primary" href="detalle?id=${p.id}">Ver
								producto</a>
						</p>
					</div>
					<div class="card-footer">
						<small class="text-body-secondary"> ${euro(p.precio)} </small>
					</div>
				</div>
			</div>
		`;


        fila.append(div);
    }
});