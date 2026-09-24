package com.amazonia.presentacion.controladores.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AnonimoNegocio;

@WebServlet("/admin/formulario")
public class FormularioControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		// 5. Saltar a la siguiente pantalla/vista
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/admin/formulario.jsp").forward(request, response);
	}

}
