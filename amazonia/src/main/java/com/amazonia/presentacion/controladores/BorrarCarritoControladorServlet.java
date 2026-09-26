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
import com.amazonia.presentacion.modelos.Carrito;
import com.amazonia.presentacion.modelos.Linea;

@WebServlet("/carrito/borrar")
public class BorrarCarritoControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		HttpSession session = request.getSession();

		Carrito carrito = (Carrito) session.getAttribute("carrito");
		
		String sId = request.getParameter("id");
		
		// 2. Convertir los datos necesarios
		Long id = Long.parseLong(sId);
		
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		borrarACarritoProducto(carrito, id);
		
		// 5. Saltar a la siguiente pantalla/vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect(request.getContextPath() + "/carrito");
	}

	private Carrito borrarACarritoProducto(Carrito carrito, Long id) {
		for(Linea linea: carrito.lineas()) {
			if(linea.producto().id() == id) {
				carrito.lineas().remove(linea);
				
				break;
			}
		}

		return carrito;
	}

}
