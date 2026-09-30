package com.amazonia.logicanegocio;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.logging.Logger;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;

public class AdministradorNegocio {
	private static final Logger log = Logger.getLogger(AdministradorNegocio.class.getName());

	public static HashMap<String, String> altaProducto(Producto producto) {
		log.info("Alta producto " + producto);

		HashMap<String, String> errores = validarProducto(producto);

		if (errores.size() == 0) {
			ProductoCrud.insertar(producto);
		}
		return errores;
	}

	public static HashMap<String, String> modificarProducto(Producto producto) {
		log.info("Modificar producto " + producto);

		HashMap<String, String> errores = validarProducto(producto);

		if (errores.size() == 0) {
			ProductoCrud.modificar(producto);
		}
		return errores;

	}

	public static HashMap<String, String> borrarProducto(Long id) {
		log.info("Borrar producto " + id);

		HashMap<String, String> errores  = new HashMap<String, String>();

		ProductoCrud.borrar(id);

		return errores;

	}

	public static HashMap<String, String> validarProducto(Producto producto) {
		HashMap<String, String> errores = new HashMap<String, String>();

		if(producto.nombre().isBlank()) {
			errores.put("nombre", "Es obligatorio");
		}

		if (producto.precio() == null || producto.precio().compareTo(BigDecimal.ZERO) < 0 || producto.precio().compareTo(new BigDecimal("999999999999999999.99")) > 0) {
			errores.put("precio", "Es obligatorio, deber ser positivo y menor que 999999999999999999,99");
		}
		

		return errores;
	}

}
