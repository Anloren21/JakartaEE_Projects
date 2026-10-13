package com.amazonia.rest.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;
import com.google.gson.Gson;

@WebServlet("/api/v1/productos/search/buscarPorNombre")
public class ProductoBuscarRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Gson GSON = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		String nombre = request.getParameter("nombre");

		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		ArrayList<Producto> productos = AnonimoNegocio.buscarProductos(nombre);

		// 5. Convertir a JSON
		String json = GSON.toJson(productos);
		
		// 6. Devolver el JSON
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		Reader entrada = request.getReader();

		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		Producto producto = GSON.fromJson(entrada, Producto.class);

		// 4. Procesar datos-Llamar a la lógica de negocio
		AdministradorNegocio.altaProducto(producto);

		// 5. Convertir a JSON
		String json = GSON.toJson(producto);

		// 6. Devolver el resultado
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_CREATED);
		PrintWriter out = response.getWriter();

		out.println(json);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		Reader entrada = request.getReader();

		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		Producto producto = GSON.fromJson(entrada, Producto.class);

		// 4. Procesar datos-Llamar a la lógica de negocio
		AdministradorNegocio.modificarProducto(producto);

		// 5. Convertir a JSON
		String json = GSON.toJson(producto);

		// 6. Devolver el resultado
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		out.println(json);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		String pathInfo = request.getPathInfo();
		String sId = pathInfo == null ? null : pathInfo.substring(1);

		// 2. Convertir los datos necesarios
		Long id = sId == null ? null : Long.parseLong(sId);

		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		AdministradorNegocio.borrarProducto(id);

		// 5. Convertir a JSON
		// 6. Devolver el JSON
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		;
	}

}
