const URL = 'api/v1/productos';

let numeroPaginas;

let pagina = 1;
let texto = '';

let alerta;
let pNumero, pInicio, pAnterior, pSiguiente, pFin;

let fila;


function euro(cantidad) {
    const fmt = new Intl.NumberFormat('es-ES', {
        style: 'currency',
        currency: 'EUR',
        minimumFractionDigits: 2,
        useGrouping: true
    });

    return fmt.format(cantidad);
}

window.addEventListener('DOMContentLoaded', async () => {
    alerta = document.querySelector('#alerta');

    pNumero = document.querySelector('#p-numero a');
    pInicio = document.querySelector('#p-inicio a');
    pAnterior = document.querySelector('#p-anterior a');
    pSiguiente = document.querySelector('#p-siguiente a');
    pFin = document.querySelector('#p-fin a');

    for (const enlacePaginacion of document.querySelectorAll('.pagination a')) {
        enlacePaginacion.addEventListener('click', paginacion);
    }

    fila = document.querySelector('#listado .row');

    alerta.style.display = 'none';

    await actualizarListadoProductos();
});

async function paginacion(e) {
    console.log(e);
    e.preventDefault();

    const id = e.target.parentElement.parentElement.id;

    console.log(id);

    switch (id) {
        case 'p-inicio': pagina = 1; break;
        case 'p-anterior': pagina > 1 && pagina--; break;
        case 'p-siguiente': pagina > numeroPaginas && pagina++; break;
        case 'p-fin': pagina = numeroPaginas; break;
    }
    console.log(pagina);

    actualizarListadoProductos();
}

async function actualizarListadoProductos() {
    const respuesta = await fetch(`${URL}?pagina=${pagina}&texto=${texto}`);
    const respuestaNumeroPaginas = await fetch(`${URL}/numero-paginas?texto=${texto}`);
    const productos = await respuesta.json();

    numeroPaginas = await respuestaNumeroPaginas.json();

    fila.innerHTML();

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

    pNumero.textContent = `${pagina} de ${numeroPaginas}`;

    pInicio.classList.remove('disabled');
    pAnterior.classList.remove('disabled');
    pSiguiente.classList.remove('disabled');
    pFin.classList.remove('disabled');

    if (pagina === 1) {
        pInicio.classList.add('disabled');
        pAnterior.classList.add('disabled');
    } else if (pagina === numeroPaginas) {
        pSiguiente.classList.add('disabled');
        pFin.classList.add('disabled');
    }
}
