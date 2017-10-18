package com.grupo4.webserver.servlet;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.servicios.Servicios;
import com.grupo4.webserver.utils.AuthUtils;

@RestController
@RequestMapping("/api/indicadores")
public class IndicadoresAPI {
	
Servicios servicios = Servicios.getInstance();
	
	@CrossOrigin
	@RequestMapping(method = GET)
	public List<Indicador> retornarIndicadores(@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getIndicadorServicio().getIndicadores(userId);
	}
	
	@CrossOrigin
	@RequestMapping(method = DELETE)
	public List<Indicador> borrarIndicador(@RequestParam(value = "id", defaultValue = "", required = false) long id,
			@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getIndicadorServicio().eliminarIndicador(id, userId);
	}
	
	@CrossOrigin
	@RequestMapping(method = POST)
	public List<Indicador> crearIndicador(
			@RequestParam(value = "nombre", defaultValue = "", required = false) String nombre,
			@RequestParam(value = "formula", defaultValue = "", required = false) String formula,
			@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getIndicadorServicio().agregarIndicador(nombre, formula, userId);
	}
	
	@CrossOrigin
	@RequestMapping(method = PUT)
	public List<Indicador> editarIndicador(
			@RequestParam(value = "nombre", defaultValue = "", required = false) String nombre,
			@RequestParam(value = "formula", defaultValue = "", required = false) String formula,
			@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getIndicadorServicio().editarIndicador(nombre, formula, userId);
	}
	
	@CrossOrigin
	@RequestMapping("/aplicar")
	public String aplicarIndicadoresA(
			@RequestParam(value = "empresa", defaultValue = "", required = false) String nombreEmpresa,
			@RequestParam(value = "periodo", defaultValue = "", required = false) int periodo,
			@RequestParam(value = "token", defaultValue = "", required = false) String token){
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			return null;
		}
		
		return servicios.getIndicadorServicio().aplicarIndicadoresA(nombreEmpresa, periodo, userId);
	}

}
