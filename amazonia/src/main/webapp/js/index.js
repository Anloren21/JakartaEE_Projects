const URL = 'api/v1/productos';

window.addEventListener('DOMContentLoaded', async() => {
	const respuesta = await fetch(URL);
	const productos = await respuesta.json();
	
	const ul = document.querySelector('#listado');
	
	for(const p of productos) {
		const li = document.createElement('li');
		li.innerHTML = `${p.nombre}: ${p.precio}`;
		
		ul.append(li);
	}
});