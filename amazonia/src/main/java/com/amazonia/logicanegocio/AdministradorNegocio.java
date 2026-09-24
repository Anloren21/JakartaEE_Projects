package com.amazonia.logicanegocio;

import java.util.logging.Logger;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;

public class AdministradorNegocio {
	private static final Logger log = Logger.getLogger(AdministradorNegocio.class.getName());

	public static void altaProducto(Producto producto) {
		log.info("Alta producto " + producto);

		ProductoCrud.insertar(producto);
	}

	public static void modificarProducto(Producto producto) {
		log.info("Modificar producto " + producto);

		ProductoCrud.modificar(producto);
	}

	public static void borrarProducto(Long id) {
		log.info("Borrar producto " + id);

		ProductoCrud.borrar(id);

	}

}
