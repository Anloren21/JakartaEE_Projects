package com.amazonia.logicanegocio;

import com.amazonia.accesodato.ClienteCrud;
import com.amazonia.accesodato.UsuarioCrud;
import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Usuario;

public class UsuarioNegocio {

	public static Usuario registrarCliente(Usuario usuario, Cliente cliente) {
		Cliente clienteGuardado = ClienteCrud.insertar(cliente);
		UsuarioCrud.modificarCliente(usuario.id(), clienteGuardado.id());
		
		Usuario usuarioCliente = new Usuario(usuario.id(), usuario.nombre(), usuario.email(), usuario.password(),
				usuario.rol(), clienteGuardado);

		return usuarioCliente;
	}

}