package accesodatos;

import java.sql.*;
import java.util.*;

import dto.Alquiler;

public class AlquilerDAO {

    private static final String SQL_INSERT = """
            INSERT INTO alquileres (
                equipo_id,
                cantidad,
                fecha_fin_prevista
            )
            VALUES (?, ?, ?)
            """;

    private static final String SQL_SELECT_ALL = """
            SELECT
                id,
                equipo_id,
                cantidad,
                fecha_alquiler,
                fecha_fin_prevista,
                fecha_devolucion,
                estado
            FROM alquileres
            ORDER BY id DESC
            """;
    
    private static final String SQL_DEVOLVER = """
            UPDATE alquileres
            SET
                estado = 'DEVUELTO',
                fecha_devolucion = NOW()
            WHERE id = ?
            AND estado = 'ACTIVO'
            """;


    private AlquilerDAO() {
    }


    public static void insertarAlquiler(Alquiler a)throws SQLException{
    	String sql="INSERT INTO alquileres(equipo_id,cantidad,fecha_fin_prevista) VALUES(?,?,?)";

    	try(Connection c=ConexionBD.getConnection();PreparedStatement p=c.prepareStatement(sql)){
    		p.setInt(1,a.getEquipoId());
    		p.setInt(2,a.getCantidad());
    		p.setTimestamp(3,Timestamp.valueOf(a.getFechaFinPrevista()));
    		p.executeUpdate();
    	}
    }
    
    public static List<Alquiler> obtenerTodos() throws SQLException {

        List<Alquiler> alquileres = new ArrayList<>();

        try ( Connection con = ConexionBD.getConnection();

            PreparedStatement ps = con.prepareStatement( SQL_SELECT_ALL );

            ResultSet rs = ps.executeQuery()  ) {

            while (rs.next()) {

                Alquiler alquiler =
                        new Alquiler();


                alquiler.setId( rs.getInt("id") );


                alquiler.setEquipoId( rs.getInt("equipo_id"));


                alquiler.setCantidad(rs.getInt("cantidad"));


                Timestamp fechaAlquiler =rs.getTimestamp("fecha_alquiler");

                if (fechaAlquiler != null) {

                    alquiler.setFechaAlquiler(fechaAlquiler.toLocalDateTime());
                }


                Timestamp fechaFin = rs.getTimestamp("fecha_fin_prevista");

                if (fechaFin != null) {
                	alquiler.setFechaFinPrevista(fechaFin.toLocalDateTime());
                }


                Timestamp fechaDevolucion =rs.getTimestamp("fecha_devolucion");

                if (fechaDevolucion != null) {

                    alquiler.setFechaDevolucion(fechaDevolucion.toLocalDateTime());
                }

                alquiler.setEstado(rs.getString("estado"));


                alquileres.add(alquiler);
            }
        }

        return alquileres;
    }
    
    public static void devolverAlquiler(int id)throws SQLException{
    	String sql="UPDATE alquileres SET estado='DEVUELTO',fecha_devolucion=NOW() WHERE id=? AND estado='ACTIVO'";

    	try(Connection c=ConexionBD.getConnection();PreparedStatement p=c.prepareStatement(sql)){
    		p.setInt(1,id);

    		if(p.executeUpdate()==0)
    			throw new SQLException("El alquiler no existe o ya fue devuelto");
    	}
    }

}