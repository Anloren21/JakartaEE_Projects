package presentacion;

import java.io.*;

import accesodatos.RolCrud;
import dto.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.*;

import accesodatos.*;

@WebServlet("/usuario")
public class FormularioUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	
    	//Codificación a usar y en vision de HTML
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();
    	
    	Usuario usuario = new Usuario(0L, "", "", "", 0L, "");
    	
    	String strId = request.getParameter("id");
    	
    	if (strId != null) {
    		Long id = Long.parseLong(strId);
    		
    		usuario = UsuariosCrud.obtenerPorId(id);
    	}
    	
    	out.printf("""
    			<!DOCTYPE html>
				<html>
					<head>
						<title>Mantenimiento de usuarios</title>
					</head>
					<body>
					
						<h1> Mantenimiento de Usuarios</h1>
						
						<form action="usuario" method="post">
							<input name="id" placeholder="Id" value="%s">
							<input name="nombre" placeholder="Nombre" value="%s">
							<input name="email" placeholder="Email" value="%s">
							<input name="contraseña" placeholder="Contraseña">
							
							<button>Guardar</button>
						</form>
					</body>
				</html>
						""", usuario.id(),
		    				usuario.nombre(),
		    				usuario.email()
		    				 );
		
	}
    
    protected void doPOST(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
    	//1. Recibir la información de la petición
    	String strId = request.getParameter("id");
    	String nombre = request.getParameter("nombre");
    	String email = request.getParameter("email");
    	String password = request.getParameter("passwrod");
    	
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
    	
    	//5. Saltar a la siguiente pantalla
    	response.sendRedirect("usuarios");
    }
}