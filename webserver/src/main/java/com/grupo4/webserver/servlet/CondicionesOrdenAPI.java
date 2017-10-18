package com.grupo4.webserver.servlet;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.servicios.Servicios;
import com.grupo4.webserver.utils.AuthUtils;

@RestController
@RequestMapping("/api/condicionesorden")
public class CondicionesOrdenAPI {
	
	Servicios servicios = Servicios.getInstance();
	
	@CrossOrigin
	@RequestMapping(method = GET)
	public List<CondicionOrden> retornarCondicionesOrden(@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getCondicionOrdenServicio().getCondicionesOrden(userId);
	}
	
	@CrossOrigin
	@RequestMapping(method = DELETE)
	public List<CondicionOrden> borrarCondicionOrden(@RequestParam(value = "nombre", defaultValue = "", required = false) String nombre,
			@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getCondicionOrdenServicio().borrarCondicion(nombre, userId);
		
	}

}