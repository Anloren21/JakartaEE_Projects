package com.amazonia.logicanegocio;

import com.amazonia.accesodato.ProductoCrud;

public class AdministradorNegocio {

	public static void borrarProducto(Long id) {
		System.out.println("Borrar producto " + id);
		
		ProductoCrud.borrar(id);

	}

}
