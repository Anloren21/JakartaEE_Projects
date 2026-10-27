package com.amazonia.logicanegocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.accesodato.FacturaCrud;
import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Factura.Linea;
import com.amazonia.presentacion.modelos.Carrito;

public class ClienteNegocio {
	private static final Logger log = Logger.getLogger(ClienteNegocio.class.getName());

	public static Factura facturar(Cliente cliente, Carrito carrito) {
		ArrayList<Linea> lineas = new ArrayList<Linea>();

		for (com.amazonia.presentacion.modelos.Linea linea : carrito.lineas()) {
			lineas.add(new Linea(linea.producto(), linea.cantidad()));
		}

		Factura facturaProvisional = new Factura(null, null, LocalDate.now(), cliente, lineas);

		log.info("FACTURA PROVISIONAL: " + facturaProvisional.toString());

		Factura facturaDefinitiva = FacturaCrud.insertar(facturaProvisional);

		log.info("FACTURA DEFINITIVA: " + facturaDefinitiva.toString());

		return facturaDefinitiva;
	}

	public static Factura verFactura(Long id) {
		return FacturaCrud.obtenerPorId(id);
	}

	public static ArrayList<Factura> listarFacturas(Long id) {
		return FacturaCrud.obtenerPorIdCliente(id);
	}

}