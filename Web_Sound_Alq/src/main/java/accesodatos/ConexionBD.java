package accesodatos;

import java.util.*;
import java.sql.*;

public class ConexionBD {
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/alquiler_equipos";
	public static final String JDBC_USER = "root";
	public static final String JDBC_PASS = "";
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver " + JDBC_DRIVER, e);
		}
	}
	
	public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                JDBC_URL,
                JDBC_USER,
                JDBC_PASS
        );
    }
}