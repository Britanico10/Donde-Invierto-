package com.grupo4.webserver.servlet;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.servicios.Servicios;
import com.grupo4.webserver.utils.AuthUtils;

@RestController
@RequestMapping("/api/condicionesfiltro")
public class CondicionesFiltroAPI {
	
	Servicios servicios = Servicios.getInstance();

	@RequestMapping(method = GET)
	public List<CondicionFiltro> retornarCondicionesFiltro(@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getCondicionFiltroServicio().getCondicionesFiltro(userId);
	}
	
	@RequestMapping(method = DELETE)
	public List<CondicionFiltro> borrarCondicionFiltro(@RequestParam(value = "nombre", defaultValue = "", required = false) String nombre,
			@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getCondicionFiltroServicio().borrarCondicion(nombre, userId);
		
	}
}
