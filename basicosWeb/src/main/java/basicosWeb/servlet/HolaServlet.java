package basicosWeb.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.*;


@WebServlet("/holaservlet")
public class HolaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	//Codificación a usar y en vision de HTML
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.append("""
    			<!DOCTYPE html>
				<html>
					<head>
						<title>Basicos Web</title>
					</head>
					<body>
						<h1>Hola a Todos, ¿Qué tal estáis? </h1>	
					</body>
				</html>
				""");
		
	}
}