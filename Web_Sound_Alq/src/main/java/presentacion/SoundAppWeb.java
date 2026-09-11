package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.*;
import com.sun.net.httpserver.*;
import api.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/web")
public class SoundAppWeb extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	//Codificación a usar y en vision de HTML
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html");
 
		HttpServer s=HttpServer.create(new InetSocketAddress(8080),0);

		s.createContext("/api/equipos",new EquiposHandler());
		s.createContext("/api/categorias",new CategoriaHandler());
		s.createContext("/api/alquileres/devolver",new DevolverAlquilerHandler());
		s.createContext("/api/alquileres",new AlquileresHandler());

		s.createContext("/",e->{
			String r=e.getRequestURI().getPath();
			if(r.equals("/"))r="/index.jsp";

			Path b=Path.of("src","webapp").toAbsolutePath().normalize();
			Path f=b.resolve(r.substring(1)).normalize();

			if(!f.startsWith(b)||!Files.exists(f)){
				e.sendResponseHeaders(404,-1);e.close();return;
			}

			String t=Files.probeContentType(f);
			if(t==null)t=r.endsWith(".css")?"text/css":
					r.endsWith(".js")?"application/javascript":"text/html";

			byte[] d=Files.readAllBytes(f);
			e.getResponseHeaders().set("Content-Type",t+"; charset=UTF-8");
			e.sendResponseHeaders(200,d.length);
			e.getResponseBody().write(d);
			e.close();
		});

		s.start();
		System.out.println("SOUND ONLINE\nhttp://localhost:8080");
		
		
	}
}