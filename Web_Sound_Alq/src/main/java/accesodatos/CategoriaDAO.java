package accesodatos;

import java.sql.*;
import java.util.*;

import dto.Categoria;

public class CategoriaDAO {

    private static final String SQL_SELECT_ALL =
            "SELECT id, nombre FROM categorias ORDER BY id";

    private CategoriaDAO() {}

    public static List<Categoria> obtenerTodas() throws SQLException {

        List<Categoria> categorias = new ArrayList<>();

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next())
                categorias.add(new Categoria(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
        }

        return categorias;
    }
}