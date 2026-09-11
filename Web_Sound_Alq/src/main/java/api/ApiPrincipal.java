package api;

import java.io.*;
import java.nio.charset.*;
import com.sun.net.httpserver.*;

public class ApiPrincipal {
	public static void responder(HttpExchange e,int c,String j)throws IOException{
		byte[] d=j.getBytes(StandardCharsets.UTF_8);
		e.getResponseHeaders().set("Content-Type","application/json;charset=UTF-8");
		e.sendResponseHeaders(c,d.length); e.getResponseBody().write(d); e.close();
	}

	public static String valor(String j,String c){
		String k="\""+c+"\":"; int i=j.indexOf(k)+k.length(),f=j.indexOf(",",i);
		if(f<0)f=j.indexOf("}",i);
		return j.substring(i,f).trim().replace("\"","");
	}

	public static String esc(String s){return s==null?"":s.replace("\\","\\\\").replace("\"","\\\"");}
}