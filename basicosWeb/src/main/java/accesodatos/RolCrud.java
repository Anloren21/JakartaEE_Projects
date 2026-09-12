package accesodatos;

import java.sql.*;
import java.util.ArrayList;

import dto.*;

import static bibliotecas.accesodatos.BaseDeDatos.*;

public record RolCrud() {
	
	private static final String SQL_SELECT = "SELECT * FROM roles r";	
	
	public static ArrayList<Rol> obtenerTodos() {
		try {
			PreparedStatement pst = crearSentencia(SQL_SELECT);
			ResultSet rs = pst.executeQuery();
			
			ArrayList<Rol> roles = new ArrayList<>();
			
			while (rs.next()) {
				Rol rol = new Rol(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripción"));
				
				roles.add(rol);
			}
			
			return roles;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido leer los roles", e);
		}
	}

}
