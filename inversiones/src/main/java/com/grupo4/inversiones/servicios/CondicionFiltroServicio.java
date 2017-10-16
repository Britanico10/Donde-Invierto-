package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.grupo4.inversiones.tools.VerificadorUsuario;

public class CondicionFiltroServicio {
	
	Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());

	public List<CondicionFiltro> getCondicionesFiltro(long idUsuario) {
			return repositorio.condicionesFiltro().buscarTodas(idUsuario);
	}
	
	public List<CondicionFiltro> borrarCondicion(long idCond, long idUsuario) {
		if (VerificadorUsuario.verificarUsuarioParaCondicionFiltro(idCond, idUsuario)) {
			repositorio.condicionesFiltro().borrarPorId(idCond);
			return getCondicionesFiltro(idUsuario);
		}
		return null;
	}

}
