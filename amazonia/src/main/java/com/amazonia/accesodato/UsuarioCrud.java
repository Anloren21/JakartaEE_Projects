package com.amazonia.accesodato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Usuario;

import bibliotecas.accesodatos.BaseDeDatos;

public class UsuarioCrud {
	private static final String SQL_SELECT_EMAIL = """
										SELECT
				u.id AS u_id,
			    u.email AS u_email,
			    u.password AS u_pass,
			    u.nombre AS u_nombre,
			    r.nombre AS r_nombre,
			    c.id AS c_id,
			    c.nombre AS c_nombre,
			    c.apellidos AS c_apellidos,
			    c.nif AS c_nif
			FROM
				usuarios u
					JOIN
				roles r ON r.id = u.roles_id
					JOIN
				clientes c ON c.id = u.clientes_id
			WHERE email = ?""";

	public static Usuario obtenerPorEmail(String email) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia(SQL_SELECT_EMAIL)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				Cliente cliente = new Cliente(rs.getLong("c_id"), rs.getString("c_nombre"), rs.getString("c_apellidos"),
						rs.getString("c_nif"));
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), rs.getString("u_email"),
						rs.getString("u_pass"), rs.getString("r_nombre"), cliente);
			}
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener el usuario " + email, e);
		}
	}
}
