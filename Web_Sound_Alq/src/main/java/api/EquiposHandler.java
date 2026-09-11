package api;

import java.io.*;
import java.nio.charset.*;
import com.sun.net.httpserver.*;
import accesodatos.*;
import dto.*;

public class EquiposHandler implements HttpHandler {
	public void handle(HttpExchange e)throws IOException{
		try{
			if(e.getRequestMethod().equals("GET"))listar(e);
			else if(e.getRequestMethod().equals("POST"))insertar(e);
			else ApiPrincipal.responder(e,405,"{\"error\":\"Método no permitido\"}");
		}catch(Exception x){ApiPrincipal.responder(e,500,"{\"error\":\"" + ApiPrincipal.esc(x.getMessage())+"\"}");}
	}

	private void listar(HttpExchange e)throws Exception{
		StringBuilder j=new StringBuilder("[");
		for(Equipo x:EquipoDAO.obtenerTodos()){
			if(j.length()>1)j.append(",");
			j.append(String.format("{\"id\":%d,\"modelo\":\"%s\",\"stockDisponible\":%d,\"categoriaId\":%d,\"categoria\":\"%s\"}",
				x.getId(),ApiPrincipal.esc(x.getModelo()),x.getStockDisponible(),x.getCategoriaId(),ApiPrincipal.esc(x.getCategoriaNombre())));
		}
		ApiPrincipal.responder(e,200,j.append("]").toString());
	}

	private void insertar(HttpExchange e)throws Exception{
		String j=new String(e.getRequestBody().readAllBytes(),StandardCharsets.UTF_8);
		EquipoDAO.insertar(ApiPrincipal.valor(j,"modelo"),Integer.parseInt(ApiPrincipal.valor(j,"stock")),Integer.parseInt(ApiPrincipal.valor(j,"categoriaId")));
		ApiPrincipal.responder(e,201,"{\"mensaje\":\"Equipo añadido\"}");
	}
}