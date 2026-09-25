package com.amazonia.accesodato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonia.dtos.Usuario;

import bibliotecas.accesodatos.BaseDeDatos;

public class UsuarioCrud {
	public static Usuario obtenerPorEmail(String email) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("SELECT *  FROM usuarios WHERE email=?")) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getString("password"), "PROVISIONAL");
			}
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener el usuario " + email, e);
		}
	}
}
