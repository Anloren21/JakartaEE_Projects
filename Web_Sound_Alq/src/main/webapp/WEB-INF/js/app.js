let equipos=[];

document.addEventListener("DOMContentLoaded",()=>{
	cargarEquipos(); cargarAlquileres();
	let f=new Date(); f.setMonth(f.getMonth()+1);
	let fecha=document.getElementById("fechaDevolucion");
	if(fecha) fecha.value=f.toISOString().split("T")[0];
});

document.getElementById("tablaEquipos").innerHTML=equipos.map(e=>{
	let clase=e.stockDisponible>0?"disponible":"sin-stock";
	let estado=e.stockDisponible>0?"Disponible":"Sin stock";

	return `<tr>
		<td>${e.id}</td>
		<td>${e.modelo}</td>
		<td>${e.categoria}</td>
		<td>${e.stockDisponible}</td>
		<td><span class="estado ${clase}">${estado}</span></td>
	</tr>`;
}).join("");

async function cargarEquipos(){
	try{
		let r=await fetch("/api/equipos");
		if(!r.ok)throw Error("HTTP "+r.status);

		equipos=await r.json();

		let tabla=document.getElementById("tablaEquipos");
		let select=document.getElementById("alquilerEquipo");

		tabla.innerHTML=equipos.map(e=>{
			let clase=e.stockDisponible>0?"disponible":"sin-stock";
			let estado=e.stockDisponible>0?"Disponible":"Sin stock";

			return `<tr>
				<td>${e.id}</td>
				<td>${e.modelo}</td>
				<td>${e.categoria}</td>
				<td>${e.stockDisponible}</td>
				<td><span class="estado ${clase}">${estado}</span></td>
			</tr>`;
		}).join("");

		select.innerHTML='<option value="">Selecciona un equipo</option>'+
			equipos.filter(e=>e.stockDisponible>0).map(e=>
				`<option value="${e.id}">${e.modelo} (${e.stockDisponible})</option>`
			).join("");

	}catch(e){
		mostrarMensaje(e.message+" - Error al cargar equipos",true);
	}
}

async function realizarAlquiler(){
	let id=+document.getElementById("alquilerEquipo").value;
	let cant=+document.getElementById("alquilerCantidad").value;

	if(!id||cant<1)return mostrarMensaje("Selecciona equipo y cantidad",true);

	try{
		let r=await fetch("/api/alquileres",{
			method:"POST",
			headers:{"Content-Type":"application/json"},
			body:JSON.stringify({equipoId:id,cantidad:cant})
		});

		let d=await r.json();
		if(!r.ok)throw Error(d.error||"Error al realizar alquiler");

		mostrarMensaje(d.mensaje||"Alquiler realizado");
		document.getElementById("alquilerCantidad").value="";
		await cargarEquipos();
		await cargarAlquileres();

	}catch(e){
		mostrarMensaje(e.message,true);
	}
}

async function cargarAlquileres(){
	try{
		let r=await fetch("/api/alquileres"); if(!r.ok)throw Error("HTTP "+r.status);
		let datos=await r.json();

		document.getElementById("tablaAlquileres").innerHTML=datos.map(a=>{
			let e=equipos.find(x=>x.id==a.equipoId);
			let vencido=a.estado=="ACTIVO"&&new Date(a.fechaFinPrevista)<new Date();
			let clase=a.estado=="DEVUELTO"?"devuelto":vencido?"vencido":"activo";
			let estado=a.estado=="DEVUELTO"?"DEVUELTO":vencido?"ATRASADO":"EN ALQUILER";

			return `<tr class="${clase}">
				<td>${a.id}</td><td>${e?e.modelo:a.equipoId}</td><td>${a.cantidad}</td>
				<td>${fecha(a.fechaAlquiler)}</td><td>${fecha(a.fechaFinPrevista)}</td>
				<td>${fecha(a.fechaDevolucion)}</td>
				<td><span class="estado ${clase}">${estado}</span></td>
				<td>${a.estado=="ACTIVO"?`<button onclick="devolverAlquiler(${a.id})">Devolver</button>`:"-"}</td>
			</tr>`;
		}).join("");
	}catch(e){mostrarMensaje(e.message+" - Error al cargar alquileres",true);}
}

async function devolverAlquiler(id){
	try{
		let r=await fetch("/api/alquileres/devolver?id="+id,{method:"POST"});
		let d=await r.json();
		if(!r.ok)throw Error(d.error||"Error al devolver");

		mostrarMensaje(d.mensaje);
		await cargarEquipos();
		await cargarAlquileres();

	}catch(e){mostrarMensaje(e.message,true);}
}

function fecha(v){return v?new Date(v).toLocaleDateString("es-ES"):"-";}

function mostrarMensaje(t,error=false){
	let m=document.getElementById("mensaje");
	m.textContent=t; m.className=error?"mensaje error":"mensaje correcto";
}