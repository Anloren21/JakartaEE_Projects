package com.amazonia.logicanegocio;

import java.util.ArrayList;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;

public class AnonimoNegocio {
	public static ArrayList<Producto> listarProductos() {
		return ProductoCrud.obtenerTodos();
	}
}
