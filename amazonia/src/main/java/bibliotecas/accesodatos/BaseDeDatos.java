package bibliotecas.accesodatos;

import java.sql.*;
import java.util.Properties;
import java.io.*;


public class BaseDeDatos {
	private static final String JDBC_DRIVER;
	private static final String JDBC_URL;
	private static final String JDBC_USER;
	private static final String JDBC_PASS;

	static {
		try {
			Properties props = new Properties();
			props.load(BaseDeDatos.class.getClassLoader().getResourceAsStream("basededatos.properties"));
			
			JDBC_DRIVER = props.getProperty("jdbc.driver");
			JDBC_URL = props.getProperty("jdbc.url");
			JDBC_USER = props.getProperty("jdbc.user");
			JDBC_PASS = props.getProperty("jdbc.pass");
			
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver " , e);
		}catch (IOException e){
			throw new RuntimeException("No se ha podido abrir la configuración");
		}
	}

	public static PreparedStatement crearSentencia(String sql) {
		try {
			Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			PreparedStatement pst = con.prepareStatement(sql);
			
			return pst;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido conectar a la base de datos", e);
		}
	}
}
