package com.amazonia.logicanegocio;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;

public class AdministradorNegocio {

	public static void altaProducto(Producto producto) {
		System.out.println("Alta producto " + producto);

		ProductoCrud.insertar(producto);
	}

	public static void modificarProducto(Producto producto) {
		System.out.println("Modificar producto " + producto);

		ProductoCrud.modificar(producto);
	}

	public static void borrarProducto(Long id) {
		System.out.println("Borrar producto " + id);

		ProductoCrud.borrar(id);

	}

}
