package com.amazonia.dtos;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(Long id, String numero, LocalDate fecha, Cliente cliente, ArrayList<Linea> lineas) {
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
}

