package com.amazonia.presentacion.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.accesodato.ProductoCrud;
import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Producto;
import com.amazonia.dtos.Usuario;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;
import com.amazonia.logicanegocio.ClienteNegocio;
import com.amazonia.presentacion.modelos.Carrito;
import com.amazonia.presentacion.modelos.Linea;

@WebServlet("/facturar")
public class FacturarControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(FacturarControladorServlet.class.getName());
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir la información de la petición
		HttpSession session = request.getSession();
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Cliente cliente = usuario.cliente();
		
		// 2. Convertir los datos necesarios
		// 3. Crear objeto
		// 4. Procesar datos-Llamar a la lógica de negocio
		Factura factura = ClienteNegocio.facturar(cliente, carrito);
		
		log.info(factura.toString());
		
		// 5. Saltar a la siguiente pantalla/vista
		request.setAttribute("factura", factura);
		
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("factura.jsp").forward(request, response);
	}

}
