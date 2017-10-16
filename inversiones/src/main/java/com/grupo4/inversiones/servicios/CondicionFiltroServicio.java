package com.grupo4.inversiones.servicios;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.repositorio.Repositorio;

public class CondicionFiltroServicio {
	
	String PERSISTENCE_UNIT_NAME = "db";
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	Repositorio repositorio = new Repositorio(emFactory.createEntityManager());

	public List<CondicionFiltro> getCondicionesFiltro(long idUsuario) {
		return repositorio.condicionesFiltro().buscarTodas(idUsuario);
	}
	
	public void borrarCondicion(long id) {
		repositorio.condicionesFiltro().borrarPorId(id);
	}

}
