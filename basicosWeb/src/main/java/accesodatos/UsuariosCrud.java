package accesodatos;

import java.sql.*;
import java.util.ArrayList;

import dto.Usuario;
import static bibliotecas.accesodatos.BaseDeDatos.*;

public class UsuariosCrud {
	
	private static final String SQL_SELECT = """
			SELECT 
				u.id AS u_id, u.email AS u_email, u.password AS u_password, u.nombre AS u_nombre, 
				r.id AS r_id, r.nombre AS r_nombre 
			FROM usuarios u
			JOIN roles r ON u.roles_id = r.id	
			""";
	
	private static final String SQL_SELECT_ID = SQL_SELECT + "WHERE u.id=?";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + "WHERE u.email=?";
	
	private static final String SQL_INSERT = "INSERT INTO usuarios (nombre, email, password, roles_id) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET nombre=?, email=?, password=?, roles_id=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";
	

	public static ArrayList<Usuario> obtenerTodos() {
		try {
			PreparedStatement pst = crearSentencia(SQL_SELECT);
			ResultSet rs = pst.executeQuery();
			
			ArrayList<Usuario> usuarios = new ArrayList<>();
			
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), 
						rs.getString("u_email"), rs.getString("u_password"), rs.getLong("r_id"), rs.getString("r_nombre"));
				
				usuarios.add(usuario);
			}
			
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido leer el listado", e);
		}
	}

	public static Usuario obtenerPorEmail(String email) {
		try (PreparedStatement pst = crearSentencia(SQL_SELECT_EMAIL)) {
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			
			Usuario usuario = null;
			
			if (rs.next()) {
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), 
						rs.getString("u_email"), rs.getString("u_password"), rs.getLong("r_id"), rs.getString("r_nombre"));
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido encontrar el usuario ", e);
		}
	}

	public static Usuario obtenerPorId(Long id) {
		try (PreparedStatement pst = crearSentencia(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Usuario usuario = null;
			
			if (rs.next()) {
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), 
						rs.getString("u_email"), rs.getString("u_password"), rs.getLong("r_id"), rs.getString("r_nombre"));
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido encontrar el usuario ", e);
		}
	}

	public static void insertar(Usuario usuario) {
		try (PreparedStatement pst = crearSentencia(SQL_INSERT)) {
			pst.setString(1, usuario.nombre());
			pst.setString(2, usuario.email());
			pst.setString(3, usuario.password());
			pst.setLong(4, usuario.rolId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido añadir el usuario ", e);
		}
	}
	
	public static void modificar(Usuario usuario) {
		try (PreparedStatement pst = crearSentencia(SQL_UPDATE)) {
			pst.setString(1, usuario.nombre());
			pst.setString(2, usuario.email());
			pst.setString(3, usuario.password());
			pst.setLong(4, usuario.rolId());
			pst.setLong(5, usuario.id());
			
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido modificar el usuario ", e);
		}
	}
	
	public static void borrar(Long id) {
		try (PreparedStatement pst = crearSentencia(SQL_DELETE)) {
			pst.setLong(1, id);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido borrar el usuario ", e);
		}
	}


}
