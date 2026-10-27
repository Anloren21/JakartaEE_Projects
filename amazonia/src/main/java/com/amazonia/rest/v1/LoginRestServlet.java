package com.amazonia.rest.v1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import com.amazonia.dtos.Usuario;
import com.amazonia.logicanegocio.AnonimoNegocio;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/v1/login")
public class LoginRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson GSON = new Gson();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Recibir informacion de la peticion
		Reader entrada = request.getReader();

		// 2. Convertir los datos
		// 3. Crear un objeto Usuario con ellos
		Usuario login = GSON.fromJson(entrada, Usuario.class);

		// 4. Llamar a la lógica de negocio
		Usuario usuarioAutenticado = AnonimoNegocio.autenticar(login);

		// 5. Validar resultado y responder
		if (usuarioAutenticado != null) {
			// Login exitoso
			// Guarda usuario en sesión
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuarioAutenticado);

			// 5. Construir respuesta JSON
			String json = GSON.toJson(usuarioAutenticado);

			// 6. Devolver el resultado
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			PrintWriter out = response.getWriter();

			out.println(json);
		} else {
			// Login fallido
			// 6. Devolver error 401 Unauthorized
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println("{\"error\": \"Email o contraseña incorrectos\"}");
		}
	}
}
