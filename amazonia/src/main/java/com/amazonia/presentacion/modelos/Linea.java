package com.amazonia.presentacion.modelos;

import java.math.BigDecimal;

import com.amazonia.dtos.Producto;

public record Linea(Producto producto, Integer cantidad) {
	private static final BigDecimal IVA = new BigDecimal("0.21");
	
	public BigDecimal subTotal() {
		return total().subtract(iva());
	}
	public BigDecimal iva() {
		return total().multiply(IVA);
	}
	public BigDecimal total() {
		return producto.precio().multiply(new BigDecimal(cantidad));
	}
}
