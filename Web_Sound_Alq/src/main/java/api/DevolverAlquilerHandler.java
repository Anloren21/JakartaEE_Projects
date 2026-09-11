package api;

import java.io.*;
import com.sun.net.httpserver.*;
import logicaalquiler.*;

public class DevolverAlquilerHandler implements HttpHandler{

	public void handle(HttpExchange e)throws IOException{
		try{
			if(!e.getRequestMethod().equals("POST")){
				ApiPrincipal.responder(e,405,"{\"error\":\"Metodo no permitido\"}");return;
			}

			String q=e.getRequestURI().getQuery();
			int id=Integer.parseInt(q.split("=")[1]);

			SoundOnlineAlquiler.devolverAlquiler(id);

			ApiPrincipal.responder(e,200,"{\"mensaje\":\"Equipo devuelto correctamente\"}");

		}catch(Exception x){
			ApiPrincipal.responder(e,400,"{\"error\":\""+ApiPrincipal.esc(x.getMessage())+"\"}");
		}
	}
}