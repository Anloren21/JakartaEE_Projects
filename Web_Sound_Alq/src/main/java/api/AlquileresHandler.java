package api;

import java.io.*;
import java.nio.charset.*;
import java.time.*;
import com.sun.net.httpserver.*;
import dto.*;
import logicaalquiler.*;

public class AlquileresHandler implements HttpHandler{

	public void handle(HttpExchange e)throws IOException{
		try{
			if(e.getRequestMethod().equals("GET"))listar(e);
			else if(e.getRequestMethod().equals("POST"))insertar(e);
			else ApiPrincipal.responder(e,405,"{\"error\":\"Metodo no permitido\"}");
		}catch(Exception x){
			ApiPrincipal.responder(e,400,"{\"error\":\""+ApiPrincipal.esc(x.getMessage())+"\"}");
		}
	}

	private void insertar(HttpExchange e)throws Exception{
		String j=new String(e.getRequestBody().readAllBytes(),StandardCharsets.UTF_8);
		int id=Integer.parseInt(ApiPrincipal.valor(j,"equipoId"));
		int cant=Integer.parseInt(ApiPrincipal.valor(j,"cantidad"));

		SoundOnlineAlquiler.realizarAlquiler(id,cant,LocalDateTime.now().plusMonths(1));

		ApiPrincipal.responder(e,201,"{\"mensaje\":\"Alquiler realizado\"}");
	}

	private void listar(HttpExchange e)throws Exception{
		StringBuilder j=new StringBuilder("[");
		for(Alquiler a:SoundOnlineAlquiler.obtenerAlquileres()){
			if(j.length()>1)j.append(",");
			String d=a.getFechaDevolucion()==null?"null":"\""+a.getFechaDevolucion()+"\"";

			j.append(String.format(
				"{\"id\":%d,\"equipoId\":%d,\"cantidad\":%d,\"fechaAlquiler\":\"%s\",\"fechaFinPrevista\":\"%s\",\"fechaDevolucion\":%s,\"estado\":\"%s\"}",
				a.getId(),a.getEquipoId(),a.getCantidad(),a.getFechaAlquiler(),
				a.getFechaFinPrevista(),d,a.getEstado()));
		}
		ApiPrincipal.responder(e,200,j.append("]").toString());
	}
}