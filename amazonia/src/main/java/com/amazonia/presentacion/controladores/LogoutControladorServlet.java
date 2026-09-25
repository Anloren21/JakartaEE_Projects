package com.amazonia.presentacion.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;
import com.amazonia.dtos.Usuario;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;

@WebServlet("/logout")
public class LogoutControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(LogoutControladorServlet.class.getName());

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		HttpSession session = request.getSession();

		log.info("Cerrando sesión de " + session.getAttribute("usuario"));
		
		session.invalidate();
		
		log.info("Se ha cerrado la sesión");
		
		// 5. Saltar a la siguiente pantalla/vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect("login");
	}

}
