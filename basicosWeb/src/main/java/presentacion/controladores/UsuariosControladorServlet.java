package presentacion.controladores;

import java.io.*;

import accesodatos.RolCrud;
import dto.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.*;

import accesodatos.*;

@WebServlet("/mvc/usuarios")
public class UsuariosControladorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
		//1. Recibir la información de la petición
    	String borrar = request.getParameter("borrar");
    	
    	System.out.println(borrar);
    	
    	if(borrar != null) {
    		//2. Convertir los datos necesarios
    		Long id = Long.parseLong(borrar);
    		//4. Procesar datos
    		UsuariosCrud.borrar(id);
    	}
    	
    	//5. Saltar a la siguiente pantalla/vista
    	request.setAttribute("usuarios", UsuariosCrud.obtenerTodos());

    	//6. Saltar a la siguiente vista
    	request.getRequestDispatcher("/WEB-INF/vistas/usuarios.jsp").forward(request, response);
    }
}