package com.amazonia.presentacion.filtros;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.*;
import java.io.*;
import java.util.logging.Logger;

import com.amazonia.dtos.Usuario;
import com.sun.net.httpserver.HttpServer;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter {
	private static final Logger log = Logger.getLogger(AdminFilter.class.getName());
	private static final long serialVersionUID = 3487889869091398638L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null && "ADMIN".equals(usuario.rol())) {
			super.doFilter(request, response, chain);

		} else {
			log.severe("INTETNO DE ENTRAR EN ADMINISTRACIÓN DE FOMRA FRAUDULENTA");
			response.sendRedirect(request.getContextPath() + "/login");
		}

	}
}
