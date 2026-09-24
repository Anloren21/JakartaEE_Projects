package com.amazonia.presentacion.controladores.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;

@WebServlet("/admin/formulario")
public class FormularioControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		String sId = request.getParameter("id");

		// 2. Convertir los datos necesarios
		if (sId != null) {

			Long id = Long.parseLong(sId);

			// 3. Crear objeto

			// 4. Procesar datos-Llamar a la lógica de negocio
			Producto producto = AnonimoNegocio.verDetalleProducto(id);

			// 5. Saltar a la siguiente pantalla/vista
			request.setAttribute("producto", producto);
		}
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/admin/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String descripción = request.getParameter("descripción");
		
		// 2. Convertir los datos necesarios
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		BigDecimal precio = new BigDecimal(sPrecio);			

		// 3. Crear objeto
		Producto producto = new Producto(id, nombre, descripción, precio);
		
		// 4. Procesar datos-Llamar a la lógica de negocio
		if(id == null) {
			AdministradorNegocio.altaProducto(producto);
		}else {
			AdministradorNegocio.modificarProducto(producto);
		}
		
		// 5. Saltar a la siguiente pantalla/vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect("listado");
	}

}
