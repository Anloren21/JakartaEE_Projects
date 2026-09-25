package com.amazonia.presentacion.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;

@WebServlet("/carrito/anadir")
public class AnadirCarritoControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(AnadirCarritoControladorServlet.class.getName());
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Producto> carrito = (ArrayList<Producto>) session.getAttribute("carrito");
		
		String sId = request.getParameter("id");
		
		// 2. Convertir los datos necesarios
		Long id = Long.parseLong(sId);
		
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		Producto producto = AnonimoNegocio.verDetalleProducto(id);
		
		log.info("Productos: " + producto);
		
		carrito.add(producto);

		// 5. Saltar a la siguiente pantalla/vista
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/carrito.jsp").forward(request, response);
	}

}
