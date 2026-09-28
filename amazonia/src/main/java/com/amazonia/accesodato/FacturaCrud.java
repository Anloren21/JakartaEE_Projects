package com.amazonia.accesodato;

import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Cliente;

public class FacturaCrud {

	public static Factura insertar(Factura facturaProvisional) {
		Cliente cliente = new Cliente(2L, "Angie", "Rojas", "98745632X");
		
		Factura factura = new Factura(1L, "2026-0002", facturaProvisional.fecha(), cliente, facturaProvisional.lineas());
		
		return factura;
	}

}
