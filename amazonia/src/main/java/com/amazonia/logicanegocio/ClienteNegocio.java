package com.amazonia.logicanegocio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Producto;
import com.amazonia.presentacion.modelos.Carrito;
import com.amazonia.presentacion.modelos.Linea;

public class ClienteNegocio {

	public static Factura facturar(Cliente cliente, Carrito carrito) {
		System.out.println("FACTURAR CONTROLADOR");

		System.out.println("TABLA facturas");
		System.out.println("Cliente id");
		System.out.println(cliente);
		System.out.println("Nº y fecha de factura");
		System.out.println("TABLA facturas_tiene_producto");
		System.out.println("Producto id");
		System.out.println("Cantidad");
		System.out.println(carrito);
		System.out.println("Después se vacía carrito");

		System.out.println("Recibimos un factura");

		Producto producto1 = new Producto(1L, "Portátil", null, new BigDecimal("1234"));
		Producto producto2 = new Producto(2L, "Teclado", null, new BigDecimal("40"));

		Linea linea1 = new Linea(producto1, 2);
		Linea linea2 = new Linea(producto2, 1);

		ArrayList<Linea> lineas = new ArrayList<Linea>();
		lineas.add(linea1);
		lineas.add(linea2);

		Cliente cliente1 = new Cliente(2L, "Angie", "Rojas", "12345678X");

		Factura factura = new Factura(1L, "2026-0002", LocalDate.now(), cliente1, lineas);

		System.out.println(factura);

		return factura;
	}

}
