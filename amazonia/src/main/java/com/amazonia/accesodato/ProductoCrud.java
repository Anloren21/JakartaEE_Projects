package com.amazonia.accesodato;

import java.sql.*;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import com.amazonia.dtos.*;

import bibliotecas.accesodatos.BaseDeDatos;

public class ProductoCrud {
	public static ArrayList<Producto> obtenerTodos() {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("SELECT *  FROM productos");
			ResultSet rs = pst.executeQuery()) {
			ArrayList<Producto> productos = new ArrayList<Producto>();

			while (rs.next()) {
				Producto producto = new Producto(rs.getLong("id"), rs.getString("nombre"),
						rs.getString("descripcion"), rs.getBigDecimal("precio"));
				producto.add(producto);
			}
			return productos;
		}catch (SQLException e) {
			throw new RuntimeException("Error en obtener los productos");
		}
	}
}
