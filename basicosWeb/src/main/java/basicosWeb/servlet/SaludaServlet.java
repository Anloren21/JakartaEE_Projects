package basicosWeb.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.*;


@WebServlet("/saluda")
public class SaludaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	//Codificación a usar y en vision de HTML
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();
    	
    	
    	String nombre = request.getParameter("nombre");
    	
    	out.append(String.format("""
    			<!DOCTYPE html>
				<html>
					<head>
						<title>Basicos Web</title>
					</head>
					<body>
						<h1>Hola %s, ¿Qué tal estás? </h1>	
					</body>
				</html>
						""", nombre));
		
	}
}