package com.amazonia.presentacion.consola;

import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AnonimoNegocio;

public class AmazoniaConsola {
	public static void main(String[] args) {
		for(Producto producto: AnonimoNegocio.listarProductos()) {
			System.out.printf("%2s %-10s %-20s %10.2f €\n", producto.id(), producto.nombre(), producto.descripción(), 
					producto.precio());
		}
		
		System.out.println(AnonimoNegocio.verDetalleProducto(2L));
	}
}
