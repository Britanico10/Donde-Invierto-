package com.grupo4.webserver.servlet;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.servicios.Servicios;
import com.grupo4.webserver.utils.AuthUtils;

@RestController
@RequestMapping("/api/empresas")
public class EmpresasAPI {
	
	Servicios servicios = Servicios.getInstance();
	
	@RequestMapping(method = GET)
	public List<Empresa> retornarEmpresas(@RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			throw new Exception("Token inválido, vuelva a iniciar sesión.");
		}
		
		return servicios.getEmpresaServicio().getEmpresas();
	}
	
	@RequestMapping(method = PUT)
	public List<Empresa> modificarEmpresa(@RequestParam(value = "id", defaultValue = "", required = false) long id,
										  @RequestParam(value = "nuevonombre", defaultValue = "nada", required = false) String nuevoNombre,
										  @RequestParam(value = "nuevoaño", defaultValue = "0", required = false) int año,
										  @RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			throw new Exception("Token inválido, vuelva a iniciar sesión.");
		}
		
		return servicios.getEmpresaServicio().modificarEmpresa(id,nuevoNombre,año);
	}
	
	@RequestMapping(method = DELETE)
	public List<Empresa> eliminarEmpresa(@RequestParam(value = "id", defaultValue = "", required = false) long id,
										 @RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			throw new Exception("Token inválido, vuelva a iniciar sesión.");
		}
		
		return servicios.getEmpresaServicio().eliminarEmpresa(id);
		
	}
	
	@RequestMapping(method = POST)
	public List<Empresa> agregarEmpresa(@RequestParam(value = "nombre", defaultValue = "nada", required = false) String nombre,
			  							@RequestParam(value = "año", defaultValue = "0", required = false) int año,
			  							@RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{
		
		long userId = AuthUtils.validarToken(token);
		if (userId == -1L) {
			throw new Exception("Token inválido, vuelva a iniciar sesión.");
		}
		
		return servicios.getEmpresaServicio().agregarEmpresa(nombre,año);
		
	}
	
}
