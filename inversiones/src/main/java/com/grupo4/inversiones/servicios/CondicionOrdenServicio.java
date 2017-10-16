package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.VerificadorUsuario;

public class CondicionOrdenServicio {
	
	Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());

	public List<CondicionOrden> getCondicionesOrden(long idUsuario) {
		return repositorio.condicionesOrden().buscarTodas(idUsuario);
	}
	
	public List<CondicionOrden> borrarCondicion(long idCond, long idUsuario) {
		if (VerificadorUsuario.verificarUsuarioParaCondicionOrden(idCond, idUsuario)) {
			repositorio.condicionesFiltro().borrarPorId(idCond);
			return getCondicionesOrden(idUsuario);
		}
		return null;
	}
	
}
