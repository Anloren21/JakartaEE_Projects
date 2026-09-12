package presentacion;

import java.io.*;

import accesodatos.RolCrud;
import dto.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.*;

import accesodatos.*;

@WebServlet("/usuarios")
public class ListadoUsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	//Codificación a usar y en vision de HTML
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();

    	String borrar = request.getParameter("borrar");
    	
    	System.out.println(borrar);
    	
    	if(borrar != null) {
    		Long id = Long.parseLong(borrar);
    		UsuariosCrud.borrar(id);
    	}
    	
    	String usuarioTexto = "";
    	
    	for(Usuario usuario: UsuariosCrud.obtenerTodos()) {
    		usuarioTexto += String.format(""" 
    						<tr>
								<th>%s</th>
								<td>%s</td>
								<td>%s</td>
								<td>%s</td>
								<td>
    								<a href="usuario?id=?">Editar</a>
    								<a href="usuarios?borrar=%s">Borrar</a>
    							</td>
							</tr>
						""",
    				usuario.id(),
    				usuario.nombre(),
    				usuario.email(),
    				usuario.rolNombre(),
    				usuario.id(),
    				usuario.id());
    	}
    	
    	out.append(String.format("""
    			<!DOCTYPE html>
				<html>
					<head>
						<title>Mantenimiento de usuarios</title>
					</head>
					<body>
					
						<h1> Mantenimiento de Usuarios</h1>
						<table border="1">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nombre</th>
									<th>Email</th>
									<th>Rol</th>
									<th>OPCIONES</th>
								</tr>
							</thead>
							<tbody>							
								%s
							</tbody>
							
							<tfoot>
								<tr>
									<td colspan="4"></td>
								<td>
    								<a href="usuario">Añadir</a>
    							</td>
								</tr>
							</tfoot>
						</table>	
					</body>
				</html>
						""", usuarioTexto));
		
	}
}