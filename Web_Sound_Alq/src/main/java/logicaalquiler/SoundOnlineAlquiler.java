package logicaalquiler;

import java.sql.*;
import java.time.*;
import java.util.*;
import accesodatos.*;
import dto.*;

public class SoundOnlineAlquiler {
	private SoundOnlineAlquiler(){}

	public static List<Equipo> obtenerEquipos()throws SQLException{return EquipoDAO.obtenerTodos();}
	public static Equipo buscarEquipo(int id)throws SQLException{return EquipoDAO.buscarPorId(id);}
	public static List<Alquiler> obtenerAlquileres()throws SQLException{return AlquilerDAO.obtenerTodos();}

	public static void realizarAlquiler(int id,int cantidad,LocalDateTime fecha)throws SQLException{
		AlquilerDAO.insertarAlquiler(new Alquiler(id,cantidad,fecha));
	}

	public static void devolverAlquiler(int id)throws SQLException{
		AlquilerDAO.devolverAlquiler(id);
	}
}