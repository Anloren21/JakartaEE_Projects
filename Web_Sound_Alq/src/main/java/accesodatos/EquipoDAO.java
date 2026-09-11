package accesodatos;

import java.sql.*;
import java.util.*;

import dto.*;

public class EquipoDAO {
	private static final String SQL_SELECT_ALL = """
            SELECT e.id, e.modelo, e.stock_disponible, e.categoria_id, c.nombre AS categoria_nombre
			FROM equipos e
			INNER JOIN categorias c ON e.categoria_id = c.id
			ORDER BY e.id;
            """;

    private static final String SQL_SELECT_BY_ID = """
            SELECT e.id, e.modelo, e.stock_disponible, e.categoria_id, c.nombre AS categoria_nombre
			FROM equipos e
			INNER JOIN categorias c ON e.categoria_id = c.id
            WHERE e.id = ?
            """;
    
    private static final String SQL_INSERT = """
            INSERT INTO equipos (modelo, stock_disponible, categoria_id)
            VALUES (?, ?, ?)
            """;

    private EquipoDAO() {
    }
    
    public static void insertar(String modelo, int stock, int categoriaId)
            throws SQLException {

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {

            ps.setString(1, modelo);
            ps.setInt(2, stock);
            ps.setInt(3, categoriaId);
            ps.executeUpdate();
        }
    }

    public static List<Equipo> obtenerTodos()
            throws SQLException {

        List<Equipo> equipos = new ArrayList<>();

        try (
            Connection con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Equipo equipo = new Equipo();
                		equipo.setId(rs.getInt("id"));
                        equipo.setModelo(rs.getString("modelo"));
                        equipo.setStockDisponible(rs.getInt("stock_disponible"));
                        equipo.setCategoriaId( rs.getInt("categoria_id"));
                        equipo.setCategoriaNombre(rs.getString("categoria_nombre") );
                        equipos.add(equipo);
                        
            }
        }

        return equipos;
    }

    public static Equipo buscarPorId(int id) throws SQLException {

        try (
            Connection con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                	 Equipo equipo =new Equipo();
		            		equipo.setId(rs.getInt("id"));
		                    equipo.setModelo(rs.getString("modelo"));
		                    equipo.setStockDisponible(rs.getInt("stock_disponible"));
		                    equipo.setCategoriaId( rs.getInt("categoria_id"));
		                    equipo.setCategoriaNombre(rs.getString("categoria_nombre") );
		                    
		                    return equipo;
                }
            }
        }

        return null;
    }
    
}
