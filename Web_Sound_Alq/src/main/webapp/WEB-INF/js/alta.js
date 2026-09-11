document.addEventListener("DOMContentLoaded",cargarCategorias);

async function cargarCategorias(){
	try{
		let r=await fetch("/api/categorias"),d=await r.json();
		document.getElementById("categoria").innerHTML=
			'<option value="">Selecciona una categoria</option>'+
			d.map(c=>`<option value="${c.id}">${c.nombre}</option>`).join("");
	}catch(e){mostrar(e.message,true);}
}

async function guardar(){
	let modelo=document.getElementById("modelo").value.trim();
	let stock=document.getElementById("stock").value;
	let categoriaId=+document.getElementById("categoria").value;

	if(!modelo||stock===""||!categoriaId)return mostrar("Completa todos los campos",true);

	try{
		let r=await fetch("/api/equipos",{
			method:"POST",headers:{"Content-Type":"application/json"},
			body:JSON.stringify({modelo,stock:+stock,categoriaId})
		});
		let d=await r.json(); if(!r.ok)throw Error(d.error);
		mostrar(d.mensaje||"Equipo anadido");
		document.getElementById("modelo").value="";
		document.getElementById("stock").value="";
	}catch(e){mostrar(e.message,true);}
}

function mostrar(t,error=false){
	let m=document.getElementById("mensaje");
	m.textContent=t; m.className=error?"mensaje error":"mensaje correcto";
}