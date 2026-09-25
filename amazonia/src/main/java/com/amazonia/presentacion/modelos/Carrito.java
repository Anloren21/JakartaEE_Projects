package com.amazonia.presentacion.modelos;

import java.math.BigDecimal;
import java.util.ArrayList;

public record Carrito(ArrayList<Linea> lineas) {
	private static final BigDecimal IVA = new BigDecimal("0.21");

	public BigDecimal subTotal() {
		return total().subtract(iva());
	}

	public BigDecimal iva() {
		return total().multiply(IVA);
	}

	public BigDecimal total() {
		BigDecimal total = BigDecimal.ZERO;

		for (Linea linea : lineas) {
			total = total.add(linea.total());
		}

		return total;
	}
}
