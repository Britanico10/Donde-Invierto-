package com.grupo4.webserver.servlet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.inversiones.Usuario;
import com.grupo4.inversiones.servicios.Servicios;
import com.grupo4.webserver.Sesion;
import com.grupo4.webserver.utils.AuthUtils;

@RestController
@RequestMapping("/api/iniciarsesion")

public class IniciarSesionAPI {
	
	Servicios servicios = Servicios.getInstance();
	
	
	@RequestMapping(method = GET)
	public @ResponseBody Sesion iniciarSesion(@RequestParam(value = "nombre", defaultValue = "", required = false) String nombre,
								 @RequestParam(value = "password", defaultValue = "", required = false) String password){
		
		
		Usuario usuario = servicios.getIniciarSesionServicio().iniciarSesion(nombre, password);
		if (usuario != null) {
			return new Sesion(AuthUtils.generarToken(usuario));
		}
		else {
			return new Sesion("");
		}
	}
	
}
