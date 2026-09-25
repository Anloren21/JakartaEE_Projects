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

@WebServlet("/login")
public class LoginControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(LoginControladorServlet.class.getName());

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		// 5. Saltar a la siguiente pantalla/vista
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// 2. Convertir los datos necesarios

		// 3. Crear objeto
		Usuario login = new Usuario(null, null, email, password, null);

		// 4. Procesar datos-Llamar a la lógica de negocio
		Usuario usuarioAutenticado = AnonimoNegocio.autenticar(login);

		if (usuarioAutenticado != null) {
			log.info("Login Correcto");

			// 5. Saltar a la siguiente pantalla/vista
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuarioAutenticado);
			
			// 6. Saltar a la siguiente vista
			response.sendRedirect("index");
		} else {
			log.warning("Login incorrecto");

			// 5. Saltar a la siguiente pantalla/vista
			// 6. Saltar a la siguiente vista
			response.sendRedirect("login");
		}

	}

}
