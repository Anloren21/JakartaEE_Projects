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

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;
import com.amazonia.logicanegocio.ClienteNegocio;
import com.amazonia.presentacion.modelos.Carrito;
import com.amazonia.presentacion.modelos.Linea;
import com.google.gson.Gson;

@WebServlet("/api/v1/facturas/*")
public class FacturaRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Gson GSON = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		// 5. Convertir a JSON
		// 6. Devolver el resultado
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		String sIdCliente = request.getParameter("idCliente");
		Carrito carrito = GSON.fromJson(request.getReader(), Carrito.class);
		
		// 2. Convertir los datos necesarios
		Long idCliente = Long.parseLong(sIdCliente);
		
		// 3. Crear objeto
		Cliente cliente = new Cliente(idCliente,null,null,null);

		// 4. Procesar datos-Llamar a la lógica de negocio
		System.out.println(cliente);
		System.out.println(carrito);
		
		Factura factura = ClienteNegocio.facturar(cliente,carrito);
		
		// 5. Convertir a JSON
		String json = GSON.toJson(factura);
		
		// 6. Devolver el resultado
		response.setContentType("application/json");
		response.getWriter().append(json);
	}

}