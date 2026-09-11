package presentacion;

import static biblioteca.Consola.*;

import java.sql.*;
import java.util.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import accesodatos.*;
import dto.*;
import logicaalquiler.SoundOnlineAlquiler;

public class ConsolaUsuario {
	
	private static final Scanner teclado = new Scanner(System.in);
	private static final int SALIR = 0;
	
	private static final String FORMATO_CABECERAS = "%-4s %-35s %-20s %-25s%n";
	private static final String FORMATO_LINEA =  "%-4d %-35s %-20d %-25s%n";

	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl("""
				
    			SOUND ONLINE - PRUEBAS
    		================================
    		1. Probar conexión a MySQL
    		
		    2. Mostrar todos los equipos
		    
		    3. Buscar equipo por ID
		    
		    4. Mostrar las categorías
		    
		    5. Realizar alquiler de equipo
		    
		    0. Salir 
		    
		    """);
	}
	
	private static int pedirOpcion() {
		return pedirInt("\nDime la opción");
	}

	private static void procesarOpcion(int opcion) {
		switch(opcion) {
             case 1->probarConexion();
             case 2->mostrarEquipos();
             case 3->buscarEquipo();
             case 4->mostrarCategorias();
             case 5->realizarAlquiler();
             case SALIR-> pl("Gracias por usar esta aplicación");
             default ->pl("Opción no válida");
		}
    }

    private static void probarConexion() {
        try (Connection con = ConexionBD.getConnection()) {
            	System.out.println("\nConexión con MySQL correcta.");
            	
        } catch (SQLException e) {

            System.out.println("\nError de conexión:");

            System.out.println(e.getMessage());
        }
    }
    
    private static void mostrarCabeceras() {
		System.out.printf(FORMATO_CABECERAS, "ID", "Modelo","Stock Disponible", "Categoría");
		System.out.printf(FORMATO_CABECERAS, "--", "------","----------------", "---------");
	}
    
    private static void mostrarEquipo(Equipo equipo) {
    	System.out.printf(FORMATO_LINEA,
                equipo.getId(),
                equipo.getModelo(),
                equipo.getStockDisponible(),
                equipo.getCategoriaId()
        );
    }

    private static void mostrarEquipos() {

        try {

            List<Equipo> equipos = EquipoDAO.obtenerTodos();

            System.out.println( "\n--- LISTADO DE EQUIPOS ---");

            if (equipos.isEmpty()) {

                System.out.println( "No hay equipos registrados.");
                return;
            }

            mostrarCabeceras();

            for (Equipo equipo : equipos) {

                mostrarEquipo(equipo);
            }

        } catch (SQLException e) {

            System.out.println("\nError al consultar los equipos:");

            System.out.println(e.getMessage());
        }
    }

    private static void buscarEquipo() {

        try {

            System.out.print("\nIntroduce el ID del equipo: ");
            
            int id = Integer.parseInt(teclado.nextLine());

            Equipo equipo = SoundOnlineAlquiler.buscarEquipo(id);

            if (equipo == null) {

                System.out.println("Equipo no encontrado.");

            } else {

                System.out.println("\nEquipo encontrado:");
                
                mostrarCabeceras();
                mostrarEquipo(equipo);
            }

        } catch (NumberFormatException e) {

            System.out.println("El ID debe ser un número.");

        } catch (SQLException e) {

            System.out.println("Error al buscar el equipo:");

            System.out.println(e.getMessage());
        }
    }
    
    private static void mostrarCategorias() {

        try {

            List<Categoria> categorias = CategoriaDAO.obtenerTodas();

            System.out.println(  "\n--- LISTADO DE CATEGORÍAS ---" );

            if (categorias.isEmpty()) {

                System.out.println(
                        "No hay categorías registradas."
                );

                return;
            }

            System.out.printf(
                    "%-5s %-30s%n",
                    "ID",
                    "CATEGORÍA"
            );

            System.out.printf(
                    "%-5s %-30s%n",
                    "--",
                    "---------"
            );

            for (Categoria categoria : categorias) {

                System.out.printf(
                        "%-5d %-30s%n",
                        categoria.getId(),
                        categoria.getNombre()
                );
            }

        } catch (SQLException e) {

            System.out.println( "\nError al consultar las categorías:" );

            System.out.println( e.getMessage() );
        }
    }

    private static void realizarAlquiler() {

        try {
            System.out.print("\nID del equipo: ");
            int equipoId = Integer.parseInt(teclado.nextLine());

            Equipo equipo = SoundOnlineAlquiler.buscarEquipo(equipoId);

            if (equipo == null) {
                System.out.println("Equipo no encontrado.");
                return;
            }

            mostrarCabeceras();
            mostrarEquipo(equipo);

            System.out.print("\nCantidad: ");
            int cantidad = Integer.parseInt(teclado.nextLine());

            System.out.print("Fecha devolución (AAAA-MM-DD HH:MM): ");
            LocalDateTime fechaFin = LocalDateTime.parse(
                    teclado.nextLine(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            );

            SoundOnlineAlquiler.realizarAlquiler(equipoId, cantidad, fechaFin);

            System.out.println("\nAlquiler realizado correctamente.");

            mostrarCabeceras();
            mostrarEquipo(SoundOnlineAlquiler.buscarEquipo(equipoId));

        } catch (NumberFormatException e) {
            System.out.println("\nDebes introducir valores numéricos.");

        } catch (DateTimeParseException e) {
            System.out.println("\nFecha incorrecta. Usa AAAA-MM-DD HH:MM.");

        } catch (SQLException e) {
            System.out.println("\nNo se pudo realizar el alquiler: " + e.getMessage());
        }
    }
}