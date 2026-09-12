package presentacion.controladores;

import java.io.*;

import accesodatos.RolCrud;
import dto.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.*;

import accesodatos.*;

@WebServlet("/mvc/usuario")
public class UsuarioControladorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	Usuario usuario = new Usuario(0L, "", "", "", 0L, "");

    	//1. Recibir la información de la petición
    	String strId = request.getParameter("id");
    	
    	if (strId != null) {
    		//2. Convertir los datos necesarios
    		Long id = Long.parseLong(strId);
    		
    		//4. Procesar datos
    		usuario = UsuariosCrud.obtenerPorId(id);

    		//5. Saltar a la siguiente pantalla/vista
    		request.setAttribute("usuario", usuario);
    	}
    	
    	//3. Crear objeto
    	
    	//6. Saltar a la siguiente vista
    	request.getRequestDispatcher("/WEB-INF/vistas/usuario.jsp").forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
    	//1. Recibir la información de la petición
    	String strId = request.getParameter("id");
    	String nombre = request.getParameter("nombre");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	//2. Convertir los datos necesarios
    	Long id = Long.parseLong(strId);
    	
    	//3. Crear objeto
    	Usuario usuario = new Usuario(id, nombre, email, password, 2L, null);

    	//4. Hacer lo que se con él
    	if(usuario.id() == 0) {
    		UsuariosCrud.insertar(usuario);
    	}else {
    		UsuariosCrud.modificar(usuario);
    	}
    	
    	//6. Saltar a la siguiente vista
    	response.sendRedirect("usuarios");
    }
}