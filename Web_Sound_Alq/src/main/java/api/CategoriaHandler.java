package api;

import java.io.*;
import com.sun.net.httpserver.*;
import accesodatos.*;
import dto.*;

public class CategoriaHandler implements HttpHandler {
	public void handle(HttpExchange e)throws IOException{
		try{
			if(!e.getRequestMethod().equals("GET")){ApiPrincipal.responder(e,405,"{\"error\":\"Método no permitido\"}");return;}
			StringBuilder j=new StringBuilder("[");
			for(Categoria c:CategoriaDAO.obtenerTodas()){
				if(j.length()>1)j.append(",");
				j.append(String.format("{\"id\":%d,\"nombre\":\"%s\"}",c.getId(),ApiPrincipal.esc(c.getNombre())));
			}
			ApiPrincipal.responder(e,200,j.append("]").toString());
		}catch(Exception x){ApiPrincipal.responder(e,500,"{\"error\":\""+ApiPrincipal.esc(x.getMessage())+"\"}");}
	}
}