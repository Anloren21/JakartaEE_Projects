package com.amazonia.logicanegocio;

import java.util.ArrayList;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;

public class AnonimoNegocio {
	public static ArrayList<Producto> listarProductos() {
		return ProductoCrud.obtenerTodos();
	}
	
	public static Producto verDetalleProducto(Long id) {
		System.out.println("Ver detalle producto " + id);
		
		return ProductoCrud.obtenerPorId(id);
	}
}
