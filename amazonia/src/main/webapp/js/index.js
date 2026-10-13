const URL = 'api/v1/productos';

let pagina = 1;
let texto = '';

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
	const alerta = document.querySelector('#alerta');

	alerta.style.display = 'none';
		
    const respuesta = await fetch(`${URL}?pagina=${pagina}&texto=${texto}`);
	const respuestoNumeroPaginas = await fetch(`${URL}/numero-paginas?texto=${texto}`);
    const productos = await respuesta.json();
	const numeroPaginas = await respuestoNumeroPaginas.json();

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
	
	document.querySelector('#p-numero a').textContent = `${pagina} de ${numeroPaginas}`;

	if(pagina === 1) {
		document.querySelector('#p-inicio a').classList.add('disabled');
		document.querySelector('#p-anterior a').classList.add('disabled');
	}
});