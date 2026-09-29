package com.amazonia.presentacion.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Usuario;
import com.amazonia.logicanegocio.ClienteNegocio;
import com.amazonia.presentacion.modelos.Carrito;

@WebServlet("/factura")
public class FacturaControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		String sId = request.getParameter("id");
		// 2. Convertir los datos necesarios
		Long id = Long.parseLong(sId);
		
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		Factura factura = ClienteNegocio.verFactura(id);
		
		// 5. Saltar a la siguiente pantalla/vista
		request.setAttribute("factura", factura);

		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("factura.jsp").forward(request, response);
	}

}
