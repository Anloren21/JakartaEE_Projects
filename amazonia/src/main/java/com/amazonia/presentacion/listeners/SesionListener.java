package com.amazonia.presentacion.listeners;

import java.util.ArrayList;

import com.amazonia.presentacion.modelos.*;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		
		session.setAttribute("carrito", new Carrito(new ArrayList<Linea>()));
	}

}
