package accesodatos;

import java.util.*;
import java.sql.*;

public class ConexionBD {
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/alquiler_equipos";
	public static final String JDBC_USER = "root";
	public static final String JDBC_PASS = "";
	
	
	public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                JDBC_URL,
                JDBC_USER,
                JDBC_PASS
        );
    }
}