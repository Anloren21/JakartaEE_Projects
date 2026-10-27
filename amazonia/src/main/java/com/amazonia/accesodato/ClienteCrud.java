package com.amazonia.accesodato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonia.dtos.Cliente;

import bibliotecas.accesodatos.BaseDeDatos;

public class ClienteCrud {

	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, nif) VALUES (?,?,?)";

	public static Cliente insertar(Cliente cliente) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia(SQL_INSERT)) {
			pst.setString(1, cliente.nombre());
			pst.setString(2, cliente.apellidos());
			pst.setString(3, cliente.nif());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			rs.next();

			Long id = rs.getLong(1);
			
			return new Cliente(id, cliente.nombre(), cliente.apellidos(), cliente.nif());
		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar el cliente " + cliente, e);
		}
	}
}