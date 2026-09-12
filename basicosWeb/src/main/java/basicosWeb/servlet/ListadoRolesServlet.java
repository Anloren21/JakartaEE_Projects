package basicosWeb.servlet;

import java.io.*;

import accesodatos.RolCrud;
import dto.Rol;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.*;

import accesodatos.*;


@WebServlet("/roles")
public class ListadoRolesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	//Codificación a usar y en vision de HTML
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();
    	
    	
    	String rolTexto = "";
    	
    	for(Rol rol: RolCrud.obtenerTodos()) {
    		rolTexto += "<li>" + rol.nombre() + "</li>";
    	}
    	
    	out.append(String.format("""
    			<!DOCTYPE html>
				<html>
					<head>
						<title>Basicos Web</title>
					</head>
					<body>
						<ul>
							%s
						</ul>	
					</body>
				</html>
						""", rolTexto));
		
	}
}