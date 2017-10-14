package com.grupo4.webserver.servlet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.servicios.Servicios;

@RestController
@RequestMapping("/api/metodologias")
public class MetodologiasAPI {
	
Servicios servicios = Servicios.getInstance();
	
	@RequestMapping(method = GET)
	public List<Metodologia> retornarMetodologias(){
		return servicios.getMetodologiaServicio().getMetodologias();
	}

}
